public class Driver {

    double area;
    String name;

    int compare;

    Driver(){
        area = 0.0;
        name = "";
    }

    Driver(String b){
        name = b;
    }

    // getters
    public double getArea(){
        return area;
    }

    public String getName(){
        return name;
    }

    public int getCompare() {
        return compare;
    }
    //setters
    public void setArea(double a){
        area = a;
    }

    public void setName(String a){
        name = a;
    }
    public void setCompare(int a){
        compare = a;
    }

    public String toString(){
        return (name +  "\t" + area + "\n");
    }

    public boolean compareTo(Driver d, int type){
        switch(type){

            case 1: //Ascending and name, check if bigger
                if(getName().compareTo(d.getName()) > 0) {
                    return true;
                }
                break;
            case 2: //Descending and name, check if smaller
                if(getName().compareTo(d.getName()) < 0) {
                    return true;
                }
                break;
            case 3: //Ascending and area, check if smaller
                if(getArea() <= d.getArea()){
                    return true;
                }
                break;
            case 4: //Descending and name, check if bigger
                if(getArea() >= d.getArea()){
                    return true;
                }
                break;
        }
        return false;
    }











}
