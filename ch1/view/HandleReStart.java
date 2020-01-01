package ch1.view;
import ch1.data.ViewForAnimal;
import java.awt.event.*;
public class HandleReStart implements ActionListener {
     GamePanel panel;
     HandleReStart(GamePanel panel){
        this.panel = panel;
     } 
     public void actionPerformed(ActionEvent e){ //处理重新开始
       panel.saveAnimalStep.clear();
       for(int i=0;i<panel.point.length;i++) {
           panel.point[i].setIsHaveAnimal(false);
       } 
       for(int i =0;i<panel.leftAnimal.length;i++ ){
           panel.leftAnimal[i].setAtPoint(panel.point[i]);
           int x = panel.point[i].getX();
           int y = panel.point[i].getY();
           //让动物视图所在位置和动物所在点相同
           ViewForAnimal animalView =panel.leftAnimal[i].getAnimalView();
           animalView.setAnimalViewLocation(x,y);
       } 
       for(int i =0;i<panel.rightAnimal.length;i++ ){
           int m = panel.animalCount/2;
           panel.rightAnimal[i].setAtPoint(panel.point[m+1+i]);
           int x = panel.point[m+1+i].getX();
           int y = panel.point[m+1+i].getY();
           //让动物视图所在位置和动物所在点相同
           ViewForAnimal animalView =panel.rightAnimal[i].getAnimalView();
           animalView.setAnimalViewLocation(x,y);
       }  
    
     } 
}