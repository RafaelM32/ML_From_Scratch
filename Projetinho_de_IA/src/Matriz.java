public class Matriz {
    
    private float[][] vetor;
    private int length_linhas;
    private int length_colunas;

    public Matriz(int linhas, int colunas){
        this.length_linhas = linhas;
        this.length_colunas = colunas;
        this.vetor = new float[linhas][colunas];
        iniciar_matriz();
    }

    private void iniciar_matriz(){
        for(int i = 0; i < this.vetor.length; i++){
            for(int j = 0; j < this.vetor[0].length; j++){
                vetor[i][j] = 0;
            }
        }
    }

    public float[][] get_matriz(){
        return this.vetor;
    }

    public void set_matriz(float[][] vetor) {
        this.vetor = vetor;
    }

    public float get(int linha, int coluna){
        return this.vetor[linha][coluna];
    }

    public void set(int numero, int linha, int coluna){
        this.vetor[linha][coluna] = numero;
    }

    public void set(float numero, int linha, int coluna){
        this.vetor[linha][coluna] = (int) numero;
    }

    public void set_linha(int linha, float[] vetor){
        for(int i = 0; i < vetor.length;i++){
            this.vetor[linha][i] = vetor[i];
        }
    }

    public float[] get_linha(int linha){
        return this.vetor[linha];
    }

    public float[] get_coluna(int coluna){
        float[] resultado = new float[this.vetor.length];
        for(int i=0; i<this.vetor.length; i++){
            resultado[i] = this.vetor[i][coluna];
        }
        return resultado;
    }

    public void set_coluna(int coluna, float[] vetor){
        int i = 0;
        for(int linha = 0; linha<this.vetor.length; linha++){
            this.vetor[linha][coluna] = vetor[i];
            ++i;
        }
    }

    public void imprimir(){
        System.out.print("[");
        for(int i=0; i<this.vetor.length;i++){
            for(int j=0; j<this.vetor[i].length; j++){
                System.out.print(this.vetor[i][j]);
                if(j< this.vetor[0].length - 1){
                    System.out.print(" ");
                }
            }
            if(i< this.vetor.length - 1){
                System.out.println("");
                System.out.print(" ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }


    public Matriz transposta(){
        Matriz resultado = new Matriz(this.vetor[0].length, this.vetor.length);
        for(int i=0; i<this.vetor.length; i++){
            resultado.set_coluna(i, this.vetor[i]);
        }

        return resultado;
    }

    public static Matriz soma(Matriz matriz_A, Matriz matriz_B){
        Matriz resultado = new Matriz(matriz_A.get_matriz().length, matriz_B.get_matriz()[0].length);
        for(int i = 0; i<matriz_A.get_matriz().length; i++){
            for(int j = 0; j<matriz_A.get_matriz()[i].length; j++){
                resultado.set(matriz_A.get(i, j)+matriz_B.get(i, j),i,j);
            }
        }
        return resultado;
    }

    public static Matriz soma(Matriz matriz_A, int numero){
        Matriz resultado = new Matriz(matriz_A.get_matriz().length, matriz_A.get_matriz()[0].length);
        for(int i = 0; i<matriz_A.get_matriz().length; i++){
            for(int j = 0; j<matriz_A.get_matriz()[i].length; j++){
                resultado.set(matriz_A.get(i, j)+numero,i,j);
            }
        }
        return resultado;
    }

    public static Matriz multiplica(Matriz matriz_A,Matriz matriz_B){
        Matriz resultado = new Matriz(matriz_A.length_linhas, matriz_B.length_colunas);
        for(int i=0; i<resultado.length_linhas; i++){
            for(int j=0; j<resultado.length_colunas; j++){
                float soma = 0;
                for(int k=0; k<matriz_A.length_colunas; k++){
                    soma = soma + matriz_A.get(i, k)*matriz_B.get(k, j);
                }
                resultado.set(soma, i, j);
            }
        }
        return resultado;
    }

    public static Matriz multiplica(Matriz matriz_A, int numero){
        Matriz resultado = new Matriz(matriz_A.length_linhas, matriz_A.length_colunas);
        for(int i=0; i<matriz_A.length_linhas; i++){
            for(int j=0; j<matriz_A.length_colunas; j++){
                resultado.set(matriz_A.get(i, j)*numero, i, j);
            }
        }
        return resultado;
    }

    public static Matriz multiplica(Matriz matriz_A, float numero){
        Matriz resultado = new Matriz(matriz_A.length_linhas, matriz_A.length_colunas);
        for(int i=0; i<matriz_A.length_linhas; i++){
            for(int j=0; j<matriz_A.length_colunas; j++){
                resultado.set(matriz_A.get(i, j)*numero, i, j);
            }
        }
        return resultado;
    }
}
