package com.dream.java.base.operator;

import java.util.Arrays;

/**
 * 掩码.
 * http://blog.csdn.net/xiao__gui/article/details/11701893
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-10-20
 * @phone 152-5320-8570
 */

public class TestMask {

    public static void main(String[] args) {

//        bitMask1();

//        bitMask2();

        bitMask3();
    }

    public static void bitMask3() {
        String str = "4e2d"; // 十六进制数
        int num = 0;

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            char c = ch[i];

            if (c >= 'a' && c <= 'z') {
                num = num << 4 | (c - 'a' + 10);
            } else {
                num = num << 4 | (c - '0');
            }
        }
        System.out.println(num);
    }


    public static void bitMask2() {
        int num = 10;
        int mask = 0x1; // 掩码

        int[] array = new int[0];
        int i = 0;

        while (num != 0) {
            int last = mask & num;

            array = Arrays.copyOf(array, array.length + 1);
            array[i] = last;
            i++;
            num >>= 1;
        }

        for (int j = array.length - 1; j >= 0; j--) {
            System.out.print(array[j] + "");
        }
    }


    private static void bitMask1() {
        NewPermission permission = new NewPermission();

        // 添加Insert、Update、Delete三项权限
        permission.enable(NewPermission.ALLOW_INSERT | NewPermission.ALLOW_UPDATE | NewPermission.ALLOW_DELETE);

        // 设置仅允许Select和Insert权限
        permission.setPermission(NewPermission.ALLOW_SELECT | NewPermission.ALLOW_INSERT);

        // 判断是否允许Select和Insert、Update权限
        if (permission.isAllow(NewPermission.ALLOW_SELECT | NewPermission.ALLOW_INSERT | NewPermission.ALLOW_UPDATE))
            ;

        // 判断是只否允许Select和Insert权限
        if (permission.isOnlyAllow(NewPermission.ALLOW_SELECT | NewPermission.ALLOW_INSERT)) ;
    }


    public static class NewPermission {

        // 是否允许查询，二进制第1位，0表示否，1表示是
        public static final int ALLOW_SELECT = 1 << 0; // 0001

        // 是否允许新增，二进制第2位，0表示否，1表示是
        public static final int ALLOW_INSERT = 1 << 1; // 0010

        // 是否允许修改，二进制第3位，0表示否，1表示是
        public static final int ALLOW_UPDATE = 1 << 2; // 0100

        // 是否允许删除，二进制第4位，0表示否，1表示是
        public static final int ALLOW_DELETE = 1 << 3; // 1000

        // 存储目前的权限状态
        private int flag;

        /**
         * 重新设置权限
         */
        public void setPermission(int permission) {
            flag = permission;
        }

        /**
         * 添加一项或多项权限
         */
        public void enable(int permission) {
            flag |= permission;
        }

        /**
         * 删除一项或多项权限
         */
        public void disable(int permission) {
            flag &= ~permission;
        }

        /**
         * 是否拥某些权限
         */
        public boolean isAllow(int permission) {
            return (flag & permission) == permission;
        }

        /**
         * 是否禁用了某些权限
         */
        public boolean isNotAllow(int permission) {
            return (flag & permission) == 0;
        }

        /**
         * 是否仅仅拥有某些权限
         */
        public boolean isOnlyAllow(int permission) {
            return flag == permission;
        }
    }
}
