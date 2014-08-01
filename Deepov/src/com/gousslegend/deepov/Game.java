package com.gousslegend.deepov;

public class Game
{
	private Board board;
	private Player whitePlayer;
	private Player blackPlayer;

	public Game()
	{
		board = new Board();
		board.setupBoard();
		System.out.print(board);
	}

	public Player getWhitePlayer()
	{
		return whitePlayer;
	}

	public void setWhitePlayer(Player whitePlayer)
	{
		this.whitePlayer = whitePlayer;
	}

	public Player getBlackPlayer()
	{
		return blackPlayer;
	}

	public void setBlackPlayer(Player blackPlayer)
	{
		this.blackPlayer = blackPlayer;
	}

	public Board getBoard()
	{
		return board;
	}

	public static void main(String[] args)
	{
		new Game();
	}

	public int perft(int depth)
	{
		int nMoves, i;
		int nodes = 0;

		Color color = Color.BLACK;
		if (depth % 2 == 1)
		{
			color = Color.WHITE;
		}
		if (depth == 0)
		{
		//	System.out.println(board);
			return 1;
		}

		MoveList moveList = board.generateMoves(color);
		nMoves = moveList.size();


		for (i = 0; i < nMoves; i++)
		{
			board.executeMove(moveList.getList().get(i));
			nodes += perft(depth - 1);
			board.undoMove(moveList.getList().get(i));
		}
		
		return nodes;
	}
}