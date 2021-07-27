class Main extends Thread {
    static final int QUEUE_SIZE = 2;

    public void run() {
        int count = 0;
        while (!(count == 7)) {
            try {
                queue.clear();
                count++;

                if (count < 7) {
                System.out.println("Writer: count: " + count);
                }

                queue.put(count);
                try { Thread.sleep(700);
                } catch (Exception e)  {}

            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static java.util.concurrent.ArrayBlockingQueue<Integer> queue = new java.util.concurrent.ArrayBlockingQueue<Integer>(QUEUE_SIZE);

    public static void main(String[] args) {
        System.out.println("FEC-Queues");
        System.out.println("Code by Keyur Maru");
        Main writer = new Main();
        writer.start();

        int count = 0;
        while (!(count == 7)) {
            try {
                count++;
                String queueString = queue.toString();
                queueString = queueString.substring(1, queueString.length() - 1);
                System.out.println("Reader: Checking if item available");
                if (!queue.isEmpty()) {
                    System.out.println("Reader: count: " + queueString);
                }
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    }

