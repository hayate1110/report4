package jp.ac.uryukyu.ie.e225719;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    
    /**
     * エネミーの名前を返すゲッター。
     * @return エネミーの名前
    */
    public String getName() {
        return this.name;
    }

    /**
     * エネミーの名前を設定するセッター。
     * エネミー名にnullは設定できない。
     * @param name 設定する名前
    */
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    /**
     * エネミーのヒットポイントを返すゲッター。
     * @return エネミーのヒットポイント
    */
    public int getHitPoint() {
        return this.hitPoint;
    }

    /**
     * エネミーのヒットポイントを設定するセッター。
     * ヒットポイントに負の値は設定できない。
     * @param hitPoint 設定するヒットポイント値
    */
    public void setHitPoint(int hitPoint) {
        if(hitPoint >= 0) {
            this.hitPoint = hitPoint;
        }
    }

    /**
     * エネミーの攻撃力を返すゲッター。
     * @return エネミーの攻撃力
    */
    public int getAttack() {
        return this.attack;
    }

    /**
     * エネミーの攻撃力を設定するセッター。
     * 攻撃力に負の値は設定できない。
     * @param attack 設定する攻撃力
    */
    public void setAttack(int attack) {
        if(attack >= 0) {
            this.attack = attack;
        }
    }

    /**
     * エネミーの生死状態を返すゲッター。
     * @return エネミーの生死状態
    */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * エネミーの生死状態を設定するセッター。
     * @param dead 設定する生死状態
    */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}