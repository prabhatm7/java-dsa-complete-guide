/*
 * Problem: Introduction to AND, OR, XOR, NOT, shifts.
 *
 * Intuition: Bit-level operators on ints; left/right shifts multiply/divide by 2.
 * Time: O(1)  Space: O(1)
 */
public class BitwiseIntro {
    public int demo(int a, int b) {
        int and = a & b, or = a | b, xor = a ^ b, not = ~a;
        int shl = a << 2, shr = a >> 2, ushr = a >>> 2;
        return and ^ or ^ xor ^ not ^ shl ^ shr ^ ushr;
    }
}
