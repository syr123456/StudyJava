package com.syr.No1_thread.thread4;

/**
 * 三大不全的案例：1.不安全的买票+2.不安全的取钱+3.不安全的集合ArrayList
 * @author syr
 * // TODO: 2020/11/27
 * 2.不安全的取钱->加入synchronied(锁的是账户而不是银行)
 */
public class UnsefeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚基金");

        Bank you = new Bank(account,50,"你");
        Bank wife = new Bank(account,100,"女朋友");

        you.start();
        wife.start();
    }
}

class Account{
    int money;//余额
    String name;//卡的名字

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行取钱
class Bank extends Thread{
    Account account;//账户
    int drawingmoney;//取了多少钱
    int nowmoney=0;//手里还剩多少钱

    public Bank(Account account,int drawingmoney, String name){
        super(name);
        this.account = account;
        this.drawingmoney = drawingmoney;
    }

    //若在此加入synchronied,代表锁的是this，即银行，但是取钱针对的是账户，所以应该锁账户account
    @Override
    public void run() {
        //锁的应该是账户，而不是银行
        synchronized(account){
            //判断卡里是否还有钱
            if(account.money-drawingmoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            //模拟延时放大问题的发生性
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡里还剩下多少钱
            account.money = account.money - drawingmoney;

            //你手里的钱
            nowmoney = nowmoney + drawingmoney;

            System.out.println(account.name+"余额为"+account.money);
            //Thread.currentThread().getName() = this.getName()
            System.out.println(this.getName()+"手里的钱"+nowmoney);

        }
    }
}