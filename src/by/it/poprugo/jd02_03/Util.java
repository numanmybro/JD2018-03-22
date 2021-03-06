package by.it.poprugo.jd02_03;

class Util {
    static void sleep (int msTimeout) {
       try {
           //Thread.sleep(msTimeout/10);- было до использования speed
           Thread.sleep(msTimeout / Dispatcher.speed);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    static int random (int from, int to) {
        return from + (int) (Math.random()*(to-from)+1);
    }

    static int random (int count) {
        return random(0,count);
    }
}
