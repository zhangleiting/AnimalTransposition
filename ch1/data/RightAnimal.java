package ch1.data;
public class RightAnimal extends Animal{
   public boolean move(){
      int k = -1;
      boolean successMove = false;
      Point p = getAtPoint();
      for(int i=0;i<allCanAtPoint.length;i++){
         if(allCanAtPoint[i].equals(p)){
            k = i;
            break;
         }
      } 
      if(k==0){  //已经在最左面的点位置
          return false;
      }
      if(allCanAtPoint[k-1].isHaveAnimal()==false) {//前面位置上没有动物
         this.setAtPoint(allCanAtPoint[k-1]);//动物到达allCanAtPoint[k-1]点
         successMove = true;
         p.setAtPointAnimal(null);           //p点设置为无动物
         return successMove ;
      }
      if((k-1)==0){   //前面位置上是已经到达终点的动物
          return false;
      }  
      if(allCanAtPoint[k-2].isHaveAnimal()==false) {//前方隔位上没有动物
         this.setAtPoint(allCanAtPoint[k-2]); //动物到达allCanAtPoint[k-2]点
         successMove = true;
         p.setAtPointAnimal(null);           //p点设置为无动物
         return successMove ;
      }
      return successMove ;  
   }  
}
