
public class TreasureChallenge_BackTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char input[] = { '-', '-', '-', '#', '-', '-', '#', '#', '#', '-', '-', '#', '-', '-', '#', '-', '-', '-', '#',
				'-', '-', '-', '-', '#', '#', '-', '#', '#', '#', '#', '-', '#', '-', '#', '-', '#', '-', '#', '#', '-',
				'-', '-', '#', '-', '-', '-', '#', '-', '#', '@', '-', '-', '-', '#', '-', '#', '#', '#', '#', '-', '-',
				'-', '#', '#', '-', '-', '#', '-', '-', '-', '-', '-', '-', '#', '-', '-', '-', '-', '-', '#', '#', '#',
				'#', '#', '#', '#', '#', '#', '#', '#', '#', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
				'-' };
//		char input[] = { '-', '-', '-', '#', '-', '#', '#', '-', '@' };
		traverseToTreasure(input, 0);
		for (int i = 0; i < 104; i++) {
			System.out.print(input[i]);
			if ((i + 1) % 13 == 0)
				System.out.println();
		}
	}

	private static void traverseToTreasure(char[] input, int i) {
		// TODO Auto-generated method stub
		if (input[i] == '-') {
			input[i] = '+';
			int rows = 8;
			int cols = 13;
			int x = 1;
			int y = 1;

			while (x == y) {
				int p = 0;
				if ((i - cols) >= 0 && p == 0)// up
				{

					if (input[i - cols] == '@') {
						x++;
						continue;
					}
					if (input[i - cols] == '-') {
						input[i - cols] = '+';
						i = i - cols;
						p++;
					}
				}
				if (((i + 1) % cols) != 0 && p == 0)// right
				{

					if (input[i + 1] == '@') {
						x++;
						continue;
					}
					if (input[i + 1] == '-') {
						input[i + 1] = '+';
						i += 1;
						p++;
					}
				}
				if (((i + cols) < rows * cols) && p == 0)// down
				{

					if (input[i + cols] == '@') {
						x++;
						continue;
					}
					if (input[i + cols] == '-') {
						input[i + cols] = '+';
						i += cols;
						p++;
					}
				}
				if (i % cols != 0 && p == 0)// left
				{

					if (input[i - 1] == '@') {
						x++;
						continue;
					}
					if (input[i - 1] == '-') {
						input[i - 1] = '+';
						i -= 1;
						p++;
					}
				}
				if (p == 0) {
					input[i] = '!';
					if ((i - cols) >= 0 && input[i - cols] == '+')
						i -= cols;
					else if (((i + 1) % cols) != 0 && input[i + 1] == '+')
						i++;
					else if (((i + cols) < rows * cols) && input[i + cols] == '+')
						i += cols;
					else if (i % cols != 0 && input[i - 1] == '+')
						i--;
				}

			}
		}
	}

}
