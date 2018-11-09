package com.algorithmforum.tree;


public class CreatePostOrderRecusion {

    private static int preIdx = 0;

    private static void printPost(int[] in, int[] pre, int start, int end) {

        if (start > end) {
            return;
        }

        int inIdx = search(in, start, end, pre[preIdx++]);

        printPost(in, pre, start, inIdx - 1);

        printPost(in, pre, inIdx + 1, end);

        System.out.print(in[inIdx] + " ");
    }

    /**
     * This method returns the index in the inorder traversal.
     * 
     * @param in
     * @param start
     * @param end
     * @param val
     * @return return index in order traversal.
     */
    private static int search(int[] in, int start, int end, int val) {
        int j = 0;
        for (j = start; j < end; j++) {
            if (in[j] == val) {
                break;
            }
        }
        return j;
    }

    public static void main(String ars[]) {
        int in[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        int len = in.length;
        printPost(in, pre, 0, len - 1);
    }


}
