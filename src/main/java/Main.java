import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Se crea el ArrayList y se meten todos los datos
        ArrayList<Coches> al = new ArrayList<Coches>();
        al.add(new Coches("1234 ABC", 1999,"Rojo"));
        al.add(new Coches("4321 WRR", 2019,"Amarillo"));
        al.add(new Coches("9454 HSD", 2010,"Rojo"));
        al.add(new Coches("0254 JMA", 2003,"Azul"));
        al.add(new Coches("4235 JFP", 1999,"Rojo"));

        //Se crea el LinkedHashSet para eliminar los repetidos que luego vamos a seleccionar
        LinkedHashSet<Coches> lhs = new LinkedHashSet<Coches>();
        lhs.addAll(al);

        //Se crea el TreeSet para ordenar los elemento dependiendo de por cuál elijamos
        TreeSet<Coches> ts = new TreeSet<Coches>();
        ts.addAll(lhs);

        //Llamamos a la function la cual nos va a printear el resultado
        imprimir(ts);
    }

    //Creamos la function para printear el resultado
    public static void imprimir(TreeSet ts) {

        System.out.println("De esta forma se printea de forma normal");
        Iterator it = ts.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("\nDe esta forma se printea al revés");
        ArrayList<Coches> al2 = new ArrayList<Coches>();
        al2.addAll(ts);
        ListIterator<Coches> li = al2.listIterator(al2.size());
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }

    }
}
//Se crea la clase, con sus atributos
class Coches implements Comparable<Coches>{
    String matricula="";
    int ano=0;
    String color="";

    //Se crea el constructor
    public Coches(String matricula, int ano, String color) {
        this.matricula = matricula;
        this.ano = ano;
        this.color = color;
    }
    //El toString sirve para ver como quieres que te salga al printear
    public String toString(){
        return matricula+" "+ano+" "+color;
    }
    //Este metodo sirve para saber que atributos repetidos quieres eliminar
    public boolean equals(Object obj){
        if (obj instanceof Coches) {
            if (this==obj) {
                return true;
            }else {
                Coches c=(Coches)obj;
                return  c.color.equals(color);  //Aquí indicas el atributo que quieres eliminar los repetidos
            }
        } else return false;
    }
    //En este método tienes que poner los atributos que hayas puesto arriba
    public int hashCode() {
        return Objects.hash(color);
    }

    //Esto sirve ara ordenar por lo que tú quieras
    public int compareTo (Coches obj) {
        int res=0;
        res=matricula.compareTo(obj.matricula);
        if (res==0) {
            res=ano-obj.ano;
        }
        return res;
    }
}
