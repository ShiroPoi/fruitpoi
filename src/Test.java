
public class Test {
    public static void main(String [] args){
    int startX = 0, startY = 0;

    int[][] path = new int[2][6];
    int c = 0;
    for(int j = -1; j< 2;j++){
        for (int k = 0; k < 2; k++) {
            if (j != 0 || k != 0) {
                path[0][c] = startX + j;
                path[1][c] = startY + k;
                c++;
            }
        }
    }
    path[0][5]=startX;
    path[1][5]=startY -1;

    for (int i = 0; i < 6; i++){
        System.out.print(path[0][i]+",");
        System.out.print(path[1][i]+";");
        System.out.println();
    }
}
}
