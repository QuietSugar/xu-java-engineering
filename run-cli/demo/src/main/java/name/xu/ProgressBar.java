package name.xu;

/**
 * 原生 java 实现
 *
 * @author Created by Xu
 */
public class ProgressBar {
    private int index = 0;
    private String finish;
    private String unFinish;


    // 进度条粒度
    private final int PROGRESS_SIZE = 50;
    private int BITE = 2;

    private String getNChar(int num, char ch) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public void printProgress() throws InterruptedException {
        System.out.print("Progress:");

        finish = getNChar(index / BITE, '█');
        unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');
        String target = String.format("%3d%%[%s%s]", index, finish, unFinish);
        System.out.print(target);

        while (index <= 100) {
            finish = getNChar(index / BITE, '█');
            unFinish = getNChar(PROGRESS_SIZE - index / BITE, '─');

            target = String.format("%3d%%├%s%s┤", index, finish, unFinish);
            System.out.print(getNChar(PROGRESS_SIZE + 6, '\b'));
            System.out.print(target);
            Thread.sleep(50);
            index++;
        }
    }

    public static void printProgress2() {
        final long size = 1000L;
        for (int i = 0; i < 101; i++) {
            String tu = "▧";
            for (int j = 0; j < i / 10; j++) {
                tu += "▧";
            }
            System.out.print("\r当前进度：" + (i) + "%\t" + tu + "\t" + (i * 10) + "/" + size);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
