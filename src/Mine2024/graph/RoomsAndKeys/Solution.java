package Mine2024.graph.RoomsAndKeys;

import java.util.List;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> rooms = List.of(
        List.of(1),
        List.of(2),
        List.of(3),
        List.of()
    );
    System.out.println(solution.canVisitAllRooms(rooms));
  }
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int numOfRooms= rooms.size();
//    int numOfVisiteRooms = 0;
    boolean[] visited= new boolean[numOfRooms];

    visitUnlockingRooms(rooms,visited, 0);

    for(boolean b:visited){
      if(!b){
        return b;
      }
    }

    return true;

  }

  void visitUnlockingRooms(List<List<Integer>> rooms,boolean[] visited, int entranceRoom){
    if(visited[entranceRoom]){
      return;
    }
    visited[entranceRoom]=true;
    List<Integer> unlockingRooms = rooms.get(entranceRoom);
    if(unlockingRooms.isEmpty()){
      return;
    }

//    boolean allAlreadyVisited = true;
//    for(int room:unlockingRooms){
//      if(!visited[room]){
//        allAlreadyVisited=false;
//      }
//    }
//    if(allAlreadyVisited){
//      return;
//    }
    for(int room:unlockingRooms){
      visitUnlockingRooms(rooms,visited, room);
    }

  }
}
