
public class BitSet {

	
		int[] bitset;
		
		public BitSet(int size) {
			bitset = new int[(size >> 32) + 1];
		}
		
		boolean get(int pos) {
			int wordNumber = (pos >> 5);
			int bitNumber = (pos & 0x1F);
			return (bitset[wordNumber] & (1 << bitNumber)) != 0;
		}
		
		void set(int pos) {
			int wordNumber = (pos >> 5);
			int bitNumber = (pos & 0x1F);
			bitset[wordNumber] |= 1 << bitNumber;
		}
		
		public static void main(String[] args) {
			
			BitSet bs = new BitSet(32000);
			int[] numArray = new int[]{1,2,3,4,5,6,7,8,9,8,7,5,4,3,2,5};
			
			for(int i=0;i<numArray.length;i++) {
				int num = numArray[i];
				int num0 = num - 1; //bitset starts at 0, numbers start at 1;
				if(bs.get(num0)) System.out.println(num);
				else bs.set(num0);
			}
			
			return;
			
		}
}
