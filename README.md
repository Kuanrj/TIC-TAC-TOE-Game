# 🏆 TIC-TAC-TOE-Game
Creating a perfect fun and interactive Tic Tac Toe game in a console-based application using Core Java involves several steps. The game should ensure that it either results in a win for the player or a draw, This game provides two option to user either single player (AI opponent) 🤖 and Two Player (PvP) 👥 modes. 

The game logic is organized into methods, each responsible for a specific aspect of the game such as initializing the board, handling player moves, managing AI moves, checking game state, and implementing the minimax algorithm for the AI.

These methods interact to create a cohesive gameplay experience where players take turns making moves until the game reaches a conclusion. The game state is continuously checked after each move to determine if a player has won, the game is a draw, or if it should continue.

# 🎭 How it looks: 
````
       +------------------------+       
---=<<<| Welcome to TIC TAC TOE |>>>=---
       +------------------------+       
Enter Player 1 name: Neel
Select Game Mode (1: Single Player, 2: Two Player): 1
Current board:
+-----------+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+-----------+
Neel (X) enter your move (row and column): 1 1
Current board:
+-----------+
|   |   |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+-----------+
AI move: (0, 0)
Current board:
+-----------+
| O |   |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+-----------+
Neel (X) enter your move (row and column): 2 2
Current board:
+-----------+
| O | X | O |
+---+---+---+
| O | X | X |
+---+---+---+
| X | O | X |
+-----------+
Current board:
+-----------+
| O | X | O |
+---+---+---+
| O | X | X |
+---+---+---+
| X | O | X |
+-----------+
It's a draw!
Play again ? ( Yes / No ): yes

       +------------------------+       
---=<<<| Welcome to TIC TAC TOE |>>>=---
       +------------------------+       
Enter Player 1 name: Jyoti
Select Game Mode (1: Single Player, 2: Two Player): 2
Enter Player 2 name: Neel

````
# 🏅 Winning Conditions:
✅ A player wins if they place three marks in a row, column, or diagonal.

✅ If the board is full with no winner, it's a draw.

# 🌟 Features:
✅ User-Friendly Console UI – Clean board layout for an easy-to-play experience.

✅ Single Player Mode with AI – Play against a bot using the Minimax algorithm 🤖.

✅ Two Player Mode – Play against another human on the same console.

✅ Personalized Experience – Players enter their names, and the game addresses them personally.

✅ Input Validation – Ensures only valid moves can be made.

✅ Win/Draw Detection – Game automatically checks for win conditions or a draw.

✅ Play Again Option – After each match, players can choose to rematch or exit.

✅ No External Libraries Needed – Runs on pure Java (Core Java only).

# 🛠 How the Console Interaction Works: 
1. Initialization:

 - The game asks for Player 1's name.
 - The game mode is selected by the user.
 - The user is prompted to select the game mode: single player or two-player.
   - If single player is chosen, Player 2 is set as "AI".
   - If two-player mode is chosen, the program asks for Player 2's name.
2. Gameplay:

 - Players are prompted for their moves as row and column indices (0-based).
 - In single-player mode, the AI makes its moves after Player 1.
 - The current board state is printed after each move.
3. Game Over Check:

 - After each move, the game checks for a win or draw.
 - If a player wins or there is a draw, the game announces the result with the player's name 
   and exits.
4. Game End:
 - The program then asks the user if they want to play again.
 - If the user chooses to play again, the game restarts. If not, the game exits.
   
This ensures a personalized and interactive experience where players can easily play multiple games in a row or exit as they wish.

# 📌 Code Breakdown:
🏗 Classes & Methods Used

| Method | Description |
| --------------- | --------------- |
| initializeBoard() | Initializes a 3x3 empty board. |
| printBoard() | Displays the current board. | 
| playerMove() | Handles user input and moves. |
| aiMove() | AI calculates and makes a move using Minimax. |
| findBestMove() | Determines the best possible move for AI. |
| isGameOver() | Checks for win/draw conditions. |
| checkWin() | Checks if a player has won. |
| isDraw() | Checks if the board is full (game ends in draw). |

# 📜 Step-by-Step Explanation:
<p>
       <details>
              <summary>Explanation:</summary>
1. Game Start:

- The program starts by calling the main method.

- It initializes a Scanner object to read user input.

2. Game Setup:

- The game setup loop begins, allowing the game to restart if the user chooses to play again.

- initializeBoard() is called to set up the game board with empty cells.

- The program welcomes the player and asks for Player 1's name.

- The user is prompted to select the game mode: single player or two-player.
  - If single player is chosen, Player 2 is set as "AI".
  - If two-player mode is chosen, the program asks for Player 2's name.

3. Game Loop:

- The game board is printed to show its initial state.

- The main game loop begins, alternating between Player 1's and Player 2's (or AI's) moves until the game is over.

Player Move Handling:

- playerMove(scanner, player1Name, PLAYER1): Player 1 is prompted to enter their move.

- The move is validated to ensure it's within bounds and on an empty cell.

- If valid, the board is updated and printed. If not, the player is asked to enter a valid move again.

- isGameOver(PLAYER1, player1Name): The game state is checked to see if Player 1 has won or if it's a draw.
  - If the game is over, the loop breaks.

AI Move Handling (Single Player Mode):

- If in single player mode, the AI makes its move:

- aiMove(): The AI calculates the best move using findBestMove() and minimax().

- The AI's move is printed and the board is updated.

- isGameOver(PLAYER2, player2Name): The game state is checked to see if the AI has won or if it's a draw.
  - If the game is over, the loop breaks.

Second Player Move Handling (Two-Player Mode):

- If in two-player mode, Player 2 makes their move:

- playerMove(scanner, player2Name, PLAYER2): Player 2 is prompted to enter their move.

- The move is validated, the board is updated, and the board is printed.

- isGameOver(PLAYER2, player2Name): The game state is checked to see if Player 2 has won or if it's a draw.
  - If the game is over, the loop breaks.

4. Game Over:

- When the game is over (either a win or a draw), a message is displayed indicating the result.

- The program then asks the user if they want to play again:

  - System.out.print("Play again? (yes/no): ");: The user is prompted to enter "yes" or "no".

  - String playAgain = scanner.next();: The user input is read.

  - if (!playAgain.equalsIgnoreCase("yes")) { break; }: If the input is not "yes", the outer loop breaks and the game ends.
  - If the input is "yes", the outer loop continues, and the game setup process restarts.

5. Game End:

- When the user chooses not to play again, the outer loop breaks, and the program proceeds to close the Scanner object using scanner.close();, ending the game.
       </details>
</p>

# 🤖 Minimax Algorithm for AI:
The AI uses the Minimax algorithm to evaluate all possible moves.

It chooses the best possible move based on a scoring system:

. +10 for AI win

. -10 for Player win

. 0 for a draw

This ensures that AI never loses unless a perfect player plays! 🎯

# 💡 Future Enhancements:
🚀 Add a Graphical User Interface (GUI) 🎨.

🧠 Improve AI Difficulty Levels (Easy, Medium, Hard).

🌎 Enable Online Multiplayer Mode.

# ❤️ Like the project? Give it a ⭐ on GitHub!
🎯 Happy Coding! 🎮✨
