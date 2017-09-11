package org.javacore.thread.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 汽车拉力赛的类
 *
 * @author zhangwei_david
 * @version $Id: HorseRace.java, v 0.1 2015年7月3日 下午10:27:44 zhangwei_david Exp $
 */
public class CarRace {

    /**
     * 指定赛道长度
     */
    private static final int   FINISH_LINE = 75;

    /**
     * 赛道标尺线
     */
    public static final String TRACK       = "===========================================================================";

    /**
     * 参赛汽车
     */
    private List<Car> cars        = new ArrayList<>();

    private ExecutorService service     = Executors.newCachedThreadPool();

    /**
     * 门闸
     */
    private CyclicBarrier barrier;


    public CarRace(int nCars) {
        /**
         * 创建一个执行线程数量的CyclicBarrier,当所有现在都准备好以后则CyclicBarrier可以开闸放行，此时回调给定的barrierAction
         *
         */
        barrier = new CyclicBarrier(nCars, new Runnable() {

            public void run() {


                judge();
                printEvent();
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e) {

                }
            }

            /**
             * 裁判
             */
            private void judge() {
                for (Car car : cars) {
                    if (car.getStrides() >= FINISH_LINE) {
                        System.out.println(car + " won!");
                        service.shutdownNow();
                        return;
                    }
                }
            }

            /**
             * 赛事实况
             */
            private void printEvent() {
                System.out.println(TRACK);
                for (Car car : cars) {
                    System.out.println(car.tracks());
                }
                System.out.println(TRACK);
            }
        });
        for (int i = 0; i < nCars; i++) {
            Car car = new Car(barrier, String.valueOf(i));
            cars.add(car);
            service.execute(car);
        }
    }

    public static void main(String[] args) {
        new CarRace(7);
    }
}
