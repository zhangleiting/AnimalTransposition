package ch1.view;
import java.awt.*;
import ch1.data.*;
public class AnimalView extends ViewForAnimal{
   Animal animal;
   Image image;
   Toolkit tool;
   public AnimalView() {
      tool = getToolkit();
   }
   public void setAnimal(Animal animal){
      this.animal = animal;
   }
   public void setImage(String name){
      image = tool.getImage(name);
      repaint();
   } 
   public Animal getAnimal() {
      return animal;
   }
   public void setAnimalViewLocation(int x,int y){
      setLocation(x,y);
   }
   public void setAnimalViewSize(int w,int h){
      setSize(w,h);
   }
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int w=getBounds().width;
      int h=getBounds().height;
      g.drawImage(image,0,0,w,h,this);
   }
}