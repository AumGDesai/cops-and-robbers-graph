# Cops and Robbers on a Graph

> A Java-based simulation of the classic Cops and Robbers game implemented using a graph data structure. Includes dynamic player movement strategies and a real-time visual interface.

## Project Summary

This project implements:
- A graph with vertices and edges
- Custom display with coordinates and visual panels
- Multiple player strategies:
  - `RandomPlayer`
  - `MoveTowardPlayer`
  - `MoveAwayPlayer`
- A simulation driver that animates the interaction between the cop and the robber on the graph

## 📂 Key Files

- `Graph.java` — core data structure
- `Vertex.java`, `Edge.java` — graph components
- `AbstractPlayerAlgorithm.java` — base class for movement logic
- `MoveTowardPlayerAlgorithm.java` — strategy: chase the robber
- `MoveAwayPlayerAlgorithm.java` — strategy: evade the cop
- `RandomPlayer.java` — strategy: move randomly
- `GraphDisplay.java` — visual display using Swing
- `Driver.java` — main simulation loop