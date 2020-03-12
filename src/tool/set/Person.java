package tool.set;

public class Person implements Comparable{
    private String name;
    private String sex;
    private int age;

    public Person(){

    }

    public Person(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.name);
        builder.append(",");
        builder.append(this.sex);
        builder.append(",");
        builder.append(this.age);
        builder.append("}");

        return builder.toString();
    }

    
    public boolean equals(Object o){
        if(o == this){
            return true;
        }

        if(o instanceof Person){
            Person temp = (Person)o;
            if(!temp.name.equals(this.name) || !temp.sex.equals(this.sex) || !(temp.age == this.age)){
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode(){
        return this.name.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException();
        }

        if(o == this){
            return 0;
        }
        
        if(o instanceof Person){
            Person temp = (Person)o;
            int ret = this.name.compareTo(temp.name);
            if(ret == 0){
                ret = this.sex.compareTo(temp.sex);
                if(ret == 0){
                    return this.age - temp.age;
                }
            }

            return ret;
        }

        throw new ClassCastException(o.getClass() + " cannot be cast to " + this.getClass());
    }
    
}