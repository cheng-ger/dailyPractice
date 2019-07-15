package cyl.simpledatastruc.lambda;

import cyl.simpledatastruc.model.UserInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-24
 */
public class UserInfoLambda {


    public static void main(String[] args) {

        List<UserInfoModel> userInfoModelList = new ArrayList<>();

        for (int i = 0; i < 100 ; i++) {
            UserInfoModel userInfo = new UserInfoModel();

            int random =  (int) (Math.random() * 100);

            userInfo.setName(String.valueOf(random ));

            userInfo.setAge(random);

            userInfo.setSex(String.valueOf(Math.round(Math.random())));

            userInfo.setHobby(String.valueOf(random));

            userInfoModelList.add(userInfo);
        }





    }
}
