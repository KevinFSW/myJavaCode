package app.ObjectOriented.DrawStar;

public class DrawStar{
    /**
     * 画星星 倒三角
     * ***    ***
     * **      **
     * *        *
     * @param line :想画多少行
     * @param drawCh :想用什么字符画
     * @param align :true 左对齐;false 右对齐
     */
    public void starDrawHandstandRightTriangle(int line, char drawCh, boolean align){
        for (int i = 0; i < line; i++) {
            if(!align){ //右对齐先画空格
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
            }

            for (int j = 0; j < line - i; j++) {
                System.out.print(drawCh);
            }

            System.out.println();
        }
    }


}