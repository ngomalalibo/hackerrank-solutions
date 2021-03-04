package com.company;


/**
 * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 * <p>
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * 1. The first player always places "X" characters, while the second player always places "O" characters.
 * 2. "X" and "O" characters are always placed into empty squares, never filled ones.
 * 3. The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * 4. The game also ends if all squares are non-empty.
 * 5. No more moves can be played if the game is over.
 * <p>
 * Example 1:
 * Input: board = ["O  ", "   ", "   "]
 * Output: false
 * Explanation: The first player always plays "X".
 * <p>
 * Example 2:
 * Input: board = ["XOX", " X ", "   "]
 * Output: false
 * Explanation: Players take turns making moves.
 * <p>
 * Example 3:
 * Input: board = ["XXX", "   ", "OOO"]
 * Output: false
 */
public class ValidTicTacToe
{
    
    public boolean validTicTacToe(String[] board)
    {
        int leng = board.length;
        int row = 0;
        char[][] xPos = new char[board.length][];
        int xCounter = 0;
        int oCounter = 0;
        while (row < 3)
        {
            for (int i = 0; i < leng; i++)
            {
                if (board[row].charAt(i) == ' ')
                {
                    xPos[row][i] = ' ';
                }
                if (board[row].charAt(i) == 'X')
                {
                    xPos[row][i] = 'X';
                    xCounter++;
                }
                if (board[row].charAt(i) == '0')
                {
                    xPos[row][i] = '0';
                    oCounter++;
                }
                
            }
            row++;
        }
        
        int completePathCount = 0;
        /*
        X X X  0,0 0,1 0,2
        X X X  1,0 1,1 1,2
        X X X  2,0 2,1 2,2
        */
        
        if ((xPos[0][0] == 'X' && xPos[1][1] == 'X' && xPos[2][2] == 'X')) // diagonal1
        {
            completePathCount++;
        }
        if (xPos[0][2] == 'X' && xPos[1][1] == 'X' && xPos[2][0] == 'X') // diagonal2
        {
            completePathCount++;
        }
        if (xPos[0][0] == 'X' && xPos[0][1] == 'X' && xPos[0][2] == 'X') // top row
        {
            completePathCount++;
        }
        if (xPos[1][0] == 'X' && xPos[1][1] == 'X' && xPos[1][2] == 'X') // mid row
        {
            completePathCount++;
        }
        if (xPos[2][0] == 'X' && xPos[2][1] == 'X' && xPos[2][2] == 'X') // last row
        {
            completePathCount++;
        }
        if (xPos[0][0] == 'X' && xPos[0][1] == 'X' && xPos[0][2] == 'X') // col1
        {
            completePathCount++;
        }
        if (xPos[0][1] == 'X' && xPos[1][1] == 'X' && xPos[2][1] == 'X') // col2
        {
            completePathCount++;
        }
        if (xPos[0][2] == 'X' && xPos[1][2] == 'X' && xPos[2][2] == 'X') //col3
        {
            completePathCount++;
        }
        
        // check 0s
        if ((xPos[0][0] == '0' && xPos[1][1] == '0' && xPos[2][2] == '0')) // diagonal1
        {
            completePathCount++;
        }
        if (xPos[0][2] == '0' && xPos[1][1] == '0' && xPos[2][0] == '0') // diagonal2
        {
            completePathCount++;
        }
        if (xPos[0][0] == '0' && xPos[0][1] == '0' && xPos[0][2] == '0') // top row
        {
            completePathCount++;
        }
        if (xPos[1][0] == '0' && xPos[1][1] == '0' && xPos[1][2] == '0') // mid row
        {
            completePathCount++;
        }
        if (xPos[2][0] == '0' && xPos[2][1] == '0' && xPos[2][2] == '0') // last row
        {
            completePathCount++;
        }
        if (xPos[0][0] == '0' && xPos[0][1] == '0' && xPos[0][2] == '0') // col1
        {
            completePathCount++;
        }
        if (xPos[0][1] == '0' && xPos[1][1] == '0' && xPos[2][1] == '0') // col2
        {
            completePathCount++;
        }
        if (xPos[0][2] == '0' && xPos[1][2] == '0' && xPos[2][2] == '0') //col3
        {
            completePathCount++;
        }
        
        if (xCounter == 0 && oCounter > 0) // checks first character is X
        {
            return false;
        }
        if (xCounter < oCounter || Math.abs(xCounter - oCounter) > 1) // moves are made correctly (X>=0 and X-0!>1)
        {
            return false;
        }
        if (completePathCount > 1) // check there is more than one complete row, column or diagonal
        {
            return false;
        }
        return true;
    }
}