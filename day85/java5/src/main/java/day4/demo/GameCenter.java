package day4.demo;

public class GameCenter {
    //记录这局的筹码
    private int totalMoney;

    //开始游戏
    public void start() {
        System.out.println("游戏开始，请打底");

        //扣除底注
        PlayerManager.manager.betAll(Constant.BASE);

        PlayerManager.manager.show();

        //发牌
        System.out.println("开始发牌");
        PokerManager.manager.dealCards(PlayerManager.manager.players);

        PlayerManager.manager.show();

        int time = 0;//记录如果是两个人的次数
        boolean isFirst = true;
        int betMoney = 0;

        while (true) {
            //提示选择操作
            //获取当前玩家信息
            Player player = PlayerManager.manager.currentPlayer();

            //提示操作
            System.out.println("请" + player.id + "号玩家选择操作");
            Utils.showText(true, true, new String[]{"看牌", "弃牌", isFirst ? "下注" : "跟注"});
            int choice = Utils.getInput();

            boolean flag = false;
            switch (choice) {
                case 1:
                    //看牌
                    System.out.println(player.getPokerString());
                    flag = true;
                    break;
                case 2:
                    //弃牌
                    System.out.println(player.id + "号玩家弃牌!");
                    player.hasDiscard = true;
                    break;
                default:
                    //下注
                    if (isFirst) {
                        while (true) {
                            System.out.print("请输入下注金额：");
                            betMoney = Utils.getInput();

                            int result = player.bet(betMoney);
                            if (result == -1) {
                                //下注不成功
                                System.out.print("余额不足，");
                            } else {
                                //下注成功
                                isFirst = false;
                                totalMoney += betMoney;
                                break;
                            }

                        }
                    }else {
                        //跟注
                        int result = player.bet(betMoney);
                        if(result == -1){
                            //跟注失败 ,钱不够了
                            player.hasDiscard = true;
                        }else {
                            //跟注成功
                            System.out.println("跟注成功！");
                            totalMoney += betMoney;
                        }
                    }

                    break;
            }

            if(flag == false){
                //计算当前还有多少人可以参与
                int available = PlayerManager.manager.leftPlayerCount();

                if(available == 1){
                    //本局结束
                    PlayerManager.manager.changeNext();
                    Player winner = PlayerManager.manager.currentPlayer();
                    System.out.println("恭喜" + player.id+"号玩家获得胜利  获得金币：" + totalMoney);
                    break;
                }
                if(available == 2){
                    time++;
                    if(time ==  4){
                        //两个回合结束 结束游戏
                        break;
                    }
                }
                //切换到下一个人
                PlayerManager.manager.changeNext();
                PlayerManager.manager.show();

            }
        }
        PlayerManager.manager.awardWinner();
    }
}