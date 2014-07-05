package com.gousslegend.deepov.pieces
import static org.junit.Assert.assertEquals
import spock.lang.*

import com.gousslegend.deepov.Board
import com.gousslegend.deepov.Color
import com.gousslegend.deepov.Position

class WhenTestingRookMovement extends spock.lang.Specification
{

	@Shared
	def board
	@Shared
	def rook


	def setupSpec()
	{
		board = new Board()
		rook = new Rook()
	}

	def "Testing rook alone on board"()
	{
		expect:
		rook.getLegalMoves().size() == 14

		where:
		rook                                              | _
		new Rook(new Position(0, 0), board, Color.BLACK)  | _
		new Rook(new Position(7, 0), board, Color.BLACK)  | _
		new Rook(new Position(5, 0), board, Color.BLACK)  | _
		new Rook(new Position(0, 6), board, Color.BLACK)  | _
		new Rook(new Position(7, 7), board, Color.BLACK)  | _
	}

	def "Test blocked Rook"()
	{
		given:
		Board board = new Board();
		Position position = new Position(0, 0);

		Rook rook = new Rook(position, board, Color.BLACK);
		Pawn pawn1 = new Pawn(new Position(1, 0), board, Color.WHITE);
		Pawn pawn2 = new Pawn(new Position(0, 1), board, Color.WHITE);

		when:
		board.addPiece(rook);
		board.addPiece(pawn1);
		board.addPiece(pawn2);

		then:
		rook.getLegalMoves().size() == 2;
	}
}