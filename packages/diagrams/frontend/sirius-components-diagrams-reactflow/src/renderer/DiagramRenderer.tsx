/*******************************************************************************
 * Copyright (c) 2023 Obeo and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import { Selection, SelectionEntry } from '@eclipse-sirius/sirius-components-core';
import { useEffect, useRef, useState } from 'react';
import {
  Background,
  BackgroundVariant,
  EdgeChange,
  NodeChange,
  NodeSelectionChange,
  NodeTypes,
  OnEdgesChange,
  OnNodesChange,
  ReactFlow,
  useEdgesState,
  useNodesState,
  useReactFlow,
  useStoreApi,
} from 'reactflow';
import { DiagramRendererProps, DiagramRendererState, NodeData } from './DiagramRenderer.types';
import { ImageNode } from './ImageNode';
import { ListNode } from './ListNode';
import { RectangularNode } from './RectangularNode';

import 'reactflow/dist/style.css';
import { DiagramPanel } from './DiagramPanel';

const nodeTypes: NodeTypes = {
  rectangularNode: RectangularNode,
  imageNode: ImageNode,
  listNode: ListNode,
};

const isSelectChange = (change: NodeChange): change is NodeSelectionChange => change.type === 'select';

export const DiagramRenderer = ({ diagram, selection, setSelection }: DiagramRendererProps) => {
  const reactFlow = useReactFlow();
  const store = useStoreApi();
  const ref = useRef<HTMLDivElement | null>(null);
  const [state, setState] = useState<DiagramRendererState>({
    fullscreen: false,
    snapToGrid: false,
  });
  const [nodes, setNodes, onNodesChange] = useNodesState(diagram.nodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState(diagram.edges);

  useEffect(() => {
    setNodes(diagram.nodes);
    setEdges(diagram.edges);
  }, [diagram]);

  useEffect(() => {
    const selectionEntryIds = selection.entries.map((entry) => entry.id);
    const nodesIds = diagram.nodes
      .filter((node) => selectionEntryIds.includes((node.data as NodeData).targetObjectId))
      .map((node) => node.id);
    const reactFlowState = store.getState();
    reactFlowState.unselectNodesAndEdges();
    reactFlowState.addSelectedNodes(nodesIds);
  }, [selection]);

  const handleNodesChange: OnNodesChange = (changes: NodeChange[]) => {
    onNodesChange(changes);

    const selectionEntries: SelectionEntry[] = changes
      .filter(isSelectChange)
      .filter((change) => change.selected)
      .flatMap((change) => diagram.nodes.filter((node) => node.id === change.id))
      .map((node) => {
        const nodeData = node.data as NodeData;
        const { targetObjectId, targetObjectKind, targetObjectLabel } = nodeData;
        return {
          id: targetObjectId,
          kind: targetObjectKind,
          label: targetObjectLabel,
        };
      });

    const currentSelectionEntryIds = selection.entries.map((selectionEntry) => selectionEntry.id);
    const shouldUpdateSelection =
      selectionEntries.map((entry) => entry.id).filter((entryId) => currentSelectionEntryIds.includes(entryId))
        .length !== selectionEntries.length;

    if (selectionEntries.length > 0 && shouldUpdateSelection) {
      setSelection({ entries: selectionEntries });
    }
  };

  const handleEdgesChange: OnEdgesChange = (changes: EdgeChange[]) => {
    onEdgesChange(changes);
  };

  const handlePaneClick = () => {
    const selection: Selection = {
      entries: [
        {
          id: diagram.metadata.id,
          kind: diagram.metadata.kind,
          label: diagram.metadata.label,
        },
      ],
    };
    setSelection(selection);
  };

  useEffect(() => {
    const onFullscreenChange = () =>
      setState((prevState) => ({ ...prevState, fullscreen: Boolean(document.fullscreenElement) }));

    document.addEventListener('fullscreenchange', onFullscreenChange);

    return () => document.removeEventListener('fullscreenchange', onFullscreenChange);
  }, []);

  const handleFullscreen = (fullscreen: boolean) => {
    if (ref.current) {
      if (fullscreen) {
        ref.current.requestFullscreen();
      } else {
        document.exitFullscreen();
      }
    }
  };

  const handleFitToScreen = () => reactFlow.fitView({ duration: 200 });
  const handleZoomIn = () => reactFlow.zoomIn({ duration: 200 });
  const handleZoomOut = () => reactFlow.zoomOut({ duration: 200 });
  const handleSnapToGrid = (snapToGrid: boolean) => setState((prevState) => ({ ...prevState, snapToGrid }));

  return (
    <ReactFlow
      nodes={nodes}
      nodeTypes={nodeTypes}
      onNodesChange={handleNodesChange}
      edges={edges}
      onEdgesChange={handleEdgesChange}
      onPaneClick={handlePaneClick}
      maxZoom={40}
      minZoom={0.1}
      snapToGrid={state.snapToGrid}
      snapGrid={[10, 10]}
      ref={ref}>
      {state.snapToGrid ? (
        <>
          <Background
            id="small-grid"
            style={{ backgroundColor: '#ffffff' }}
            variant={BackgroundVariant.Lines}
            gap={10}
            color="#f1f1f1"
          />
          <Background id="large-grid" variant={BackgroundVariant.Lines} gap={100} offset={1} color="#cccccc" />
        </>
      ) : (
        <Background style={{ backgroundColor: '#ffffff' }} variant={BackgroundVariant.Lines} color="#ffffff" />
      )}
      <DiagramPanel
        fullscreen={state.fullscreen}
        onFullscreen={handleFullscreen}
        onFitToScreen={handleFitToScreen}
        onZoomIn={handleZoomIn}
        onZoomOut={handleZoomOut}
        snapToGrid={state.snapToGrid}
        onSnapToGrid={handleSnapToGrid}
      />
    </ReactFlow>
  );
};
