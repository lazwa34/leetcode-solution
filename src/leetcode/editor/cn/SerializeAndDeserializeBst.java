//<p>序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。</p>
//
//<p>设计一个算法来序列化和反序列化<strong> 二叉搜索树</strong> 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。</p>
//
//<p><strong>编码的字符串应尽可能紧凑。</strong></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [2,1,3]
//<strong>输出：</strong>[2,1,3]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = []
//<strong>输出：</strong>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数范围是 <code>[0, 10<sup>4</sup>]</code></li> 
// <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
// <li>题目数据 <strong>保证</strong> 输入的树是一棵二叉搜索树。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>二叉搜索树</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 432</li><li>👎 0</li></div>

package leetcode.editor.cn;

/**
 * @author wangzhiheng
 * @date 2023-09-04 08:27:27
 */
public class SerializeAndDeserializeBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer buffer = new StringBuffer();
            depth(root, buffer);
            return buffer.toString();
        }

        public void depth(TreeNode node, StringBuffer bf) {
            if (node == null) {
                return;
            }
            bf.append(node.val).append(",");
            depth(node.left, bf);
            depth(node.right, bf);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] split = data.split(",");
            return builder(split, 0, split.length - 1);
        }

        public TreeNode builder(String[] data, int l, int r) {
            if (l > r) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data[l]));
            int index = r + 1;
            for (int i = l + 1; i <= r; i++) {
                if (Integer.parseInt(data[i]) > node.val) {
                    index = i;
                    break;
                }
            }
            node.left = builder(data, l + 1, index - 1);
            node.right = builder(data, index, r);
            return node;

        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBst().new Solution();
    }
}