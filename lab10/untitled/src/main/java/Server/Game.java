package Server;

import java.util.*;

public class Game {
    private Map<String, GameBoard> games = new HashMap<>();

    public synchronized String createGame() {
        String gameId = UUID.randomUUID().toString();
        games.put(gameId, new GameBoard());
        return gameId;
    }

    public synchronized String joinGame(String gameId) {
        if (!games.containsKey(gameId)) {
            return "Error: game not found";
        }

        GameBoard board = games.get(gameId);
        if (board.isFull()) {
            return "Error: game is full";
        }

        String playerId = UUID.randomUUID().toString();
        board.addPlayer(playerId);
        return "Joined game " + gameId + " as player " + playerId;
    }

    public synchronized String makeMove(String gameId, int x, int y) {
        if (!games.containsKey(gameId)) {
            return "Error: game not found";
        }

        GameBoard board = games.get(gameId);
        if (!board.hasTwoPlayers()) {
            return "Error: game has not started yet";
        }

        String playerId = board.getCurrentPlayer();
        if (board.isGameOver()) {
            return "Game over: " + board.getWinner() + " wins";
        }

        if (!board.isValidMove(x, y)) {
            return "Error: invalid move";
        }

        board.makeMove(x, y);
        if (board.isGameOver()) {
            return "Game over: " + board.getWinner() + " wins";
        } else {
            return "Move made by player " + playerId;
        }
    }

    private static class GameBoard {
        private static final int BOARD_SIZE = 15;
        private static final int WIN_LENGTH = 5;

        private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        private List<String> players = new ArrayList<>();
        private int currentPlayerIndex = 0;

        public GameBoard() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                Arrays.fill(board[i], '.');
            }
        }

        public void addPlayer(String playerId) {
            players.add(playerId);
        }

        public boolean hasTwoPlayers() {
            return players.size() == 2;
        }

        public boolean isFull() {
            return players.size() >= 2;
        }

        public String getCurrentPlayer() {
            return players.get(currentPlayerIndex);
        }

        public boolean isValidMove(int x, int y) {
            return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] == '.';
        }

        public void makeMove(int x, int y) {
            char playerChar = currentPlayerIndex == 0 ? 'X' : 'O';
            board[x][y] = playerChar;
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        }

        public boolean isGameOver() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] != '.') {
                        if (checkHorizontal(i, j) || checkVertical(i, j) || checkDiagonal1(i, j) || checkDiagonal2(i, j)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public String getWinner() {
            if (!isGameOver()) {
                return null;
            }
            return players.get((currentPlayerIndex + 1) % 2);
        }

        private boolean checkHorizontal(int x, int y) {
            int count = 0;
            char playerChar = board[x][y];
            for (int i = y - WIN_LENGTH + 1; i <= y; i++) {
                if (i < 0 || i + WIN_LENGTH > BOARD_SIZE) {
                    continue;
                }
                boolean win = true;
                for (int j = i; j < i + WIN_LENGTH; j++) {
                    if (board[x][j] != playerChar) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkVertical(int x, int y) {
            int count = 0;
            char playerChar = board[x][y];
            for (int i = x - WIN_LENGTH + 1; i <= x; i++) {
                if (i < 0 || i + WIN_LENGTH > BOARD_SIZE) {
                    continue;
                }
                boolean win = true;
                for (int j = i; j < i + WIN_LENGTH; j++) {
                    if (board[j][y] != playerChar) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkDiagonal1(int x, int y) {
            int count = 0;
            char playerChar = board[x][y];
            for (int i = -WIN_LENGTH + 1; i <= 0; i++) {
                if (x + i < 0 || x + i + WIN_LENGTH > BOARD_SIZE || y + i < 0 || y + i + WIN_LENGTH > BOARD_SIZE) {
                    continue;
                }
                boolean win = true;
                for (int j = 0; j < WIN_LENGTH; j++) {
                    if (board[x + i + j][y + i + j] != playerChar) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkDiagonal2(int x, int y) {
            int count = 0;
            char playerChar = board[x][y];
            for (int i = -WIN_LENGTH + 1; i <= 0; i++) {
                if (x - i - WIN_LENGTH < 0 || x - i > BOARD_SIZE || y + i < 0 || y + i + WIN_LENGTH > BOARD_SIZE) {
                    continue;
                }
                boolean win = true;
                for (int j = 0; j < WIN_LENGTH; j++) {
                    if (board[x - i - j][y + i + j] != playerChar) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
            return false;
        }
    }
}