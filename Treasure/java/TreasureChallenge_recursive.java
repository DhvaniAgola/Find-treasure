
public class TreasureChallenge_recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char input[][] = { { '-', '-', '-', '#', '-', '-', '#', '#', '#', '-', '-', '#', '-' },
				{ '-', '#', '-', '-', '-', '#', '-', '-', '-', '-', '#', '#', '-' },
				{ '#', '#', '#', '#', '-', '#', '-', '#', '-', '#', '-', '#', '#' },
				{ '-', '-', '-', '#', '-', '-', '-', '#', '-', '#', '-', '-', '-' },
				{ '-', '#', '-', '#', '#', '#', '#', '-', '-', '-', '#', '#', '-' },
				{ '-', '#', '-', '-', '-', '-', '-', '-', '#', '-', '-', '-', '-' },
				{ '-', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '@' } };

//{ '-', '-', '-', '#', '-', '-', '#', '#', '#', '-', '-', '#', '-' },
//{ '-', '#', '-', '-', '-', '#', '-', '-', '-', '-', '#', '#', '-' },
//{ '#', '#', '#', '#', '-', '#', '-', '#', '-', '#', '-', '#', '#' },
//{ '-', '-', '-', '#', '-', '-', '-', '#', '-', '#', '-', '-', '-' },
//{ '-', '#', '-', '#', '#', '#', '#', '-', '-', '-', '#', '#', '-' },
//{ '-', '#', '-', '-', '-', '-', '-', '-', '#', '-', '-', '-', '-' },
//{ '-', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
//{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '@' } 

		if (traverseToTreasure(input, 0, 0)) {
			System.out.println("found");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 13; j++)
					System.out.print(input[i][j]);
				System.out.println();
			}
		} else {
			System.out.println("not found");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 13; j++)
					System.out.print(input[i][j]);
				System.out.println();
			}
		}
	}

	private static boolean traverseToTreasure(char[][] input, int i, int j) {
		// TODO Auto-generated method stub
		input[i][j] = '+';
		if (i > 0)// up
		{
			if (input[i - 1][j] == '@')
				return true;
			if (input[i - 1][j] == '-') {
				if (traverseToTreasure(input, i - 1, j))
					return true;
				else
					input[i - 1][j] = '!';
			}
		}
		if (j < 12)// right
		{
			if (input[i][j + 1] == '@')
				return true;
			if (input[i][j + 1] == '-') {
				if (traverseToTreasure(input, i, j + 1))
					return true;
				else
					input[i][j + 1] = '!';
			}
		}
		if (i < 7)// down
		{
			if (input[i + 1][j] == '@')
				return true;
			if (input[i + 1][j] == '-') {
				if (traverseToTreasure(input, i + 1, j))
					return true;
				else
					input[i + 1][j] = '!';
			}
		}
		if (j > 0)// left
		{
			if (input[i][j - 1] == '@')
				return true;
			if (input[i][j - 1] == '-') {
				if (traverseToTreasure(input, i, j - 1))
					return true;
				else
					input[i][j - 1] = '!';
			}
		}
		return false;
	}

}
