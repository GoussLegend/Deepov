package com.gousslegend.deepov.pieces
import static org.junit.Assert.assertEquals
import spock.lang.*

import com.gousslegend.deepov.Board
import com.gousslegend.deepov.Color
import com.gousslegend.deepov.Position

class WhenTestingKingMovement extends spock.lang.Specification
{

	@Shared
	def board
	@Shared
	def king


	def setupSpec()
	{
		board = new Board()
		king = new King()
	}
	
	def cleanup()
	{
		board = new Board()
	}

	def "Testing king alone on board"()
	{		
		King king = new King(position, board, Color.BLACK);
		board.addPiece(king);
		
		expect:
		king.getLegalMoves().size() <= 8
		king.getLegalMoves().size() >= 3
		
		where:
		position << Position.getAllPositionOnBoard()
	}
	def "Test blocked King with ennemy pieces"()
	{
		given:
		Position position = new Position(0, 0);

		King king = new King(position, board, Color.BLACK);
		Pawn pawn1 = new Pawn(new Position(1, 1), board, Color.WHITE);
		Pawn pawn2 = new Pawn(new Position(0, 1), board, Color.WHITE);
		Pawn pawn3 = new Pawn(new Position(1, 0), board, Color.WHITE);
		
		when:
		board.addPiece(king);
		board.addPiece(pawn1);
		board.addPiece(pawn2);
		board.addPiece(pawn3);
		
		then:
		king.getPseudoLegalMoves().size() == 3;
		king.getLegalMoves().size() == 2;
	}
	
	def "Test blocked King with ally piece"()
	{
		given:
		Position position = new Position(0, 0);

		King king = new King(position, board, Color.BLACK);
		Pawn pawn1 = new Pawn(new Position(1, 1), board, Color.BLACK);
		Pawn pawn2 = new Pawn(new Position(0, 1), board, Color.BLACK);
		Pawn pawn3 = new Pawn(new Position(1, 0), board, Color.BLACK);
		when:
		board.addPiece(king);
		board.addPiece(pawn1);
		board.addPiece(pawn2);
		board.addPiece(pawn3);
		
		then:
		king.getLegalMoves().size() == 0
	}

	def "Test 2 kings"()
	{
		given:
		King whiteKing = new King(whiteKingPosition, board, Color.WHITE)
		King blackKing = new King(blackKingPosition, board, Color.BLACK)

		board.addPiece(whiteKing)
		board.addPiece(blackKing)

		expect:
		whiteKing.getLegalMoves().size() == moveSize

		where:
		whiteKingPosition  | blackKingPosition   | moveSize
		new Position(0, 0) |  new Position(2, 1)  | 1
	}

	def "Test Capture Move on King with Ennemy Rook"()
	{
		given:
		Rook blackRook = new Rook(new Position(0, 1), board, Color.BLACK)
		King whiteKing = new King(new Position(0, 0), board, Color.WHITE)
		King blackKing = new King(new Position(2, 1), board, Color.BLACK)
		
		
		board.addPiece(blackRook)
		board.addPiece(whiteKing)
		board.addPiece(blackKing)
		
		expect:
		whiteKing.getLegalMoves().getFistMove().getCapturedPiece() == blackRook;
	}
}