package com.xyy;

import java.util.*;

/**
 * @author XYY
 * @version Id: SetRetainAll.java, v 0.1 2018/9/17 19:41 xuyuanye Exp $$
 */
public class SetRetainAll {
    public static void main(String[] args) {
        //int randomNum = new Random().nextInt(1000);
        //10000000000052;
        List<Set<String>> setList = new ArrayList<Set<String>>();
        for(int i=0;i<12;i++){
            Set<String> set = new HashSet<String>(1000);
            int random = new Random().nextInt(1000);
            for(int j=0;j<random;j++){
                int randomNum = new Random().nextInt(1000);
                set.add((10000000000000L+randomNum)+"");
            }
            setList.add(set);
        }
        System.out.println(setList);
        long start1 = System.currentTimeMillis();
        Set<String> resultSet = setList.get(0);
        for(int i=1;i<setList.size();i++){
            resultSet.retainAll(setList.get(i));
        }
        long end1 = System.currentTimeMillis();
        System.out.println("retainAll="+(end1-start1));

        long start2 = System.currentTimeMillis();
        BitSet[] bitSets=new BitSet[setList.size()];
        for(int i=0;i<setList.size();i++){
            BitSet bitSet = new BitSet(1000);
            for(String id:setList.get(i)){
                bitSet.set((int)(Long.valueOf(id)-10000000000000L));
            }
            bitSets[i]=bitSet;
        }
        BitSet resultBitSet=bitSets[0];
        for(int i=1;i<bitSets.length;i++){
            resultBitSet.and(bitSets[i]);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("BitSet="+(end2-start2));
        }
}
