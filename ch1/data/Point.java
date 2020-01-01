package ch1.data;
public class Point{
    int x,y; 
    boolean haveAnimal; 
    Animal animal=null; //在该点位置上的动物
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public boolean isHaveAnimal(){
        return haveAnimal;
    }
    public void setIsHaveAnimal(boolean boo){
        haveAnimal=boo;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setAtPointAnimal(Animal animal){
        this.animal=animal;
        if(animal!=null) {
           haveAnimal = true;
        }
        else {
           haveAnimal = false;
        }
    }
    public Animal getAtPointAnimal(){
        return animal;
    }
}
