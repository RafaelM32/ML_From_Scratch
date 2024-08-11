public class App {
    public static void main(String[] args) throws Exception {
        Matriz A = new Matriz(2, 2);
        Matriz B = new Matriz(2, 3);

        float[] vec1 = {3,2};
        float[] vec2 = {5,-1};

        float[] vec3 = {6,4,-2};
        float[] vec4 = {0,7,1};



        A.set_linha(0, vec1);
        A.set_linha(1, vec2);

        B.set_linha(0, vec3);
        B.set_linha(1, vec4);

        A.imprimir();
        B.imprimir();

        Matriz.multiplica(A, B).imprimir();



    }
}
