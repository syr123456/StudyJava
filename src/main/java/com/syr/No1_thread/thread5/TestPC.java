package com.syr.No1_thread.thread5;

/**
 * 管程法
 * @author syr
 * // TODO: 2020/11/27
 * 生产者消费者问题：利用缓冲区解决
 * 生产者，消费者，产品，缓冲区
 */
public class TestPC {
    public static void main(String[] args) {
        Container container = new Container();

        new Productor(container).start();
        new Consumer(container).start();

    }

}

//生产者
class Productor extends Thread{
    Container container;

    public Productor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            try {
                container.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer extends Thread{
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                System.out.println("消费了第"+container.pop().id+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//产品
class Chicken{
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class Container{
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;


    //需要生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        //如果容器满了需要等待消费者消费
        if(count==chickens.length){
            //通知消费这消费
            this.wait();
        }

        //如果没有满需要丢入产品
        chickens[count] = chicken;
        count++;

        //通知消费者消费
        this.notifyAll();
    }

    //需要消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
        //判断能否消费
        if(count==0){
            //等待生产者生产
            this.wait();
        }

        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //通知生产者生产
        this.notifyAll();
        return chicken;
    }

}