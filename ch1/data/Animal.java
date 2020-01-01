package ch1.data;
public abstract class Animal {
    String name ;
    Point [] allCanAtPoint;    //全部点位置
    Point point;               //动物当前所在的点位置
    ViewForAnimal animalView;  //动物的外观视图
    public void setAtPoint(Point p) {
        if(p!=null){
           point = p;
           point.setIsHaveAnimal(true);
           point.setAtPointAnimal(this);
        } 
    }
    public Point getAtPoint() {
        return point;
    }
    public void setAllCanAtPoint(Point [] point){
        allCanAtPoint = point;
    }
    public void setAnimalView(ViewForAnimal animalView) {
        this.animalView = animalView;
        animalView.setAnimal(this);
    }
    public ViewForAnimal getAnimalView() {
         return animalView;
    }
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
    public abstract boolean move();
}