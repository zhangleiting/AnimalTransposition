package ch1.data;
public class LeftAnimal extends Animal{
   public boolean move(){
      int k = -1;
      boolean successMove = false;
      Point p = getAtPoint();
      for(int i=0;i<allCanAtPoint.length;i++){
         if(allCanAtPoint[i].equals(p)){ 
            k = i; //找到动物当前所处的位置:allCanAtPoint[k]
            break;
         }
      } 
      if(k==allCanAtPoint.length-1){//已经在最右面的点位置
          return false;
      }
      if(allCanAtPoint[k+1].isHaveAnimal()==false) { //前面位置上没有动物
         this.setAtPoint(allCanAtPoint[k+1]);
         successMove = true;
         p.setAtPointAnimal(null);
         return successMove ;
      }
      if((k+1)==allCanAtPoint.length-1){ //前面位置上是已经到达终点的动物
          return false;
      }
      if(allCanAtPoint[k+2].isHaveAnimal()==false) {//前方隔位上没有动物
         this.setAtPoint(allCanAtPoint[k+2]);
         successMove = true;
         p.setAtPointAnimal(null);
         return successMove ;
      }
      return successMove ;  
   }  
}
