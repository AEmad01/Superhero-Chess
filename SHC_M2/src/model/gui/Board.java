//spaghetti but it works

package model.gui;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.NonActivatablePowerHero;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Board extends JLayeredPane implements MouseListener, MouseMotionListener, ChangeListener {
	int clickcounter;
	static JLayeredPane JBorderLayout;
	public static JPanel chessBoard;
	MouseListener x1;
	Super Super1;

	MouseListener t1;
	boolean techclick;
	boolean techrelease;
	boolean techdrag;
	Piece techtarget;
	Piece techtarget2;
	boolean exit;
	Ranged Ranged1;
	static String p1;
	static String p2;
	MouseMotionListener xd3;
	int rangedclickcount;
	Piece Rangeduptarget;
	Piece Rangeddowntarget;
	public static boolean gameended;
	boolean superclick;
	boolean superdrag;
	boolean superrelease;
	static boolean Ai = false;
	Piece Rangedrighttarget;
	Piece Rangedlefttarget;
	boolean rangedrelease;
	boolean rangeddrag;
	boolean rangedclick;
	Boolean rangedleftclick = false;
	Tech tech1;
	Boolean toggle = false;
	ArrayList<Integer> techradius = new ArrayList<Integer>();
	ArrayList<Integer> techradiusI = new ArrayList<Integer>();
	ArrayList<Integer> techradiusJ = new ArrayList<Integer>();

	static ArrayList<Piece> alive2 = new ArrayList<Piece>();

	ArrayList<Integer> techblue = new ArrayList<Integer>();
	ArrayList<Integer> techgreen = new ArrayList<Integer>();
	ArrayList<Integer> techred = new ArrayList<Integer>();

	ArrayList<Integer> rangedblueup = new ArrayList<Integer>();
	ArrayList<Integer> rangedgreenup = new ArrayList<Integer>();
	ArrayList<Integer> rangedredup = new ArrayList<Integer>();
	ArrayList<Integer> rangedradiusup = new ArrayList<Integer>();

	ArrayList<Integer> rangedbluedown = new ArrayList<Integer>();
	ArrayList<Integer> rangedgreendown = new ArrayList<Integer>();
	ArrayList<Integer> rangedreddown = new ArrayList<Integer>();
	ArrayList<Integer> rangedradiusdown = new ArrayList<Integer>();

	static ArrayList<Direction> randomdir = new ArrayList<Direction>();

	ArrayList<Integer> rangedblueright = new ArrayList<Integer>();
	ArrayList<Integer> rangedgreenright = new ArrayList<Integer>();
	ArrayList<Integer> rangedredright = new ArrayList<Integer>();
	ArrayList<Integer> rangedradiusright = new ArrayList<Integer>();

	ArrayList<Integer> rangedblueleft = new ArrayList<Integer>();
	ArrayList<Integer> rangedgreenleft = new ArrayList<Integer>();
	ArrayList<Integer> rangedredleft = new ArrayList<Integer>();
	ArrayList<Integer> rangedradiusleft = new ArrayList<Integer>();

	ArrayList<Integer> superblue = new ArrayList<Integer>();
	ArrayList<Integer> superred = new ArrayList<Integer>();
	ArrayList<Integer> supergreen = new ArrayList<Integer>();
	ArrayList<Direction> superdir = new ArrayList<Direction>();
	ArrayList<Integer> superradius = new ArrayList<Integer>();
	ArrayList<Integer> superclean = new ArrayList<Integer>();

	ArrayList<Integer> superI = new ArrayList<Integer>();
	ArrayList<Integer> superJ = new ArrayList<Integer>();

	ArrayList<Integer> rangedradius = new ArrayList<Integer>();
	ArrayList<Direction> rangeddir = new ArrayList<Direction>();

	ArrayList<Integer> techclean = new ArrayList<Integer>();
	ArrayList<Integer> glowradius = new ArrayList<Integer>();
	ArrayList<Integer> unglowradius = new ArrayList<Integer>();
	int techclickcount;
	boolean techclick2;
	boolean techclick3;

	boolean techdrag2;
	boolean techdrag3;
	boolean techrelease2;
	boolean techrelease3;
	static Image SideKickP1glow;
	static Image SideKickP2glow;
	static Image Super1glow;
	static Image Medic1glow;
	static Image Speedster1glow;
	static Image Armored1glow;
	static Image Armored1downglow;
	static Image Tech1glow;
	static Image Ranged1glow;

	static Image Super2glow;
	static Image Medic2glow;
	static Image Speedster2glow;
	static Image Armored2glow;
	static Image Armored2downglow;
	static Image tech2glow;
	static Image Ranged2glow;

	static Image Super2down;
	static Image Medic2down;
	static Image tech2down;
	static Image Ranged2down;

	static Image Super1down;
	static Image Medic1down;
	static Image tech1down;
	static Image Ranged1down;

	static Image Super1glowdown;
	static Image Medic1glowdown;
	static Image Tech1glowdown;
	static Image Ranged1glowdown;
	static Image SideKickp1i;
	static Image SideKickp2i;
	static Image Super2glowdown;
	static Image Medic2glowdown;
	static Image Tech2glowdown;
	static Image Ranged2glowdown;
	static Image Super1i;
	static Image Medic1i;
	static Image Speedster1i;
	static Image Armored1i;
	static Image Tech1i;
	static Image Ranged1i;
	static Image Armored1downi;
	static Image Armored2downi;

	static Image Super2i;
	static Image Medic2i;
	static Image Speedster2i;
	static Image Armored2i;
	static Image Tech2i;
	static Image Ranged2i;


	MouseMotionListener y1;
	static JPanel graveyard1;
	static JPanel graveyard2;
	Piece target = null;
	BackgroundPanel progress;
	MouseMotionListener xd2;
	BackgroundPanel progressin;
	static int x;
	int y;
	static JPanel payload1;
	static JPanel bottom;
	static JPanel top;

	static JPanel payload2;
	ArrayList<Integer> radius = new ArrayList<Integer>();
	ArrayList<Integer> radiusI = new ArrayList<Integer>();
	ArrayList<Integer> radiusJ = new ArrayList<Integer>();

	ArrayList<Direction> MedicDir = new ArrayList<Direction>();

	ArrayList<Integer> cleanI = new ArrayList<Integer>();
	ArrayList<Integer> cleanJ = new ArrayList<Integer>();
	ArrayList<Integer> clean = new ArrayList<Integer>();
	ArrayList<Integer> cleanMedic = new ArrayList<Integer>();

	boolean empty;
	JLabel chessPiece;
	static JLabel player1f = new JLabel("1");
	static JLabel player2f = new JLabel("2");
	int xAdjustment;
	int yAdjustment;
	BackgroundPanel old;
	ArrayList<Integer> iwrap = new ArrayList<>();
	ArrayList<Integer> jwrap = new ArrayList<>();
	Component c1;
	int cordIorig;
	int cordJorig;
	Boolean zombie = false;
	static Game game;
	boolean flag;
	int counter = 0;
	int counter2 = 0;
	static JPanel panel;
	static JPanel starpanel;

	Dimension boardSize = new Dimension(650, 880);
	Dimension boardSize1 = new Dimension(600, 600);
	Dimension gravesize = new Dimension(600, 100);
	Dimension payloadsize = new Dimension(25, 800);
	Dimension bottomsize = new Dimension(650, 92);
	static Dimension topsize = new Dimension(650, 92);

	public static void ini() throws IOException {
		randomdir.add(Direction.LEFT);
		
		randomdir.add(Direction.RIGHT);
		randomdir.add(Direction.UP);
		randomdir.add(Direction.DOWN);

		randomdir.add(Direction.UPLEFT);
		randomdir.add(Direction.UPRIGHT);
		randomdir.add(Direction.DOWNRIGHT);
		randomdir.add(Direction.DOWNLEFT);

		Super2down = ImageIO.read(Board.class.getResource("/images/super2down.png"));
		Medic2down = ImageIO.read(Board.class.getResource("/images/medic2down.png"));
		tech2down = ImageIO.read(Board.class.getResource("/images/tech2down.png"));
		Ranged2down = ImageIO.read(Board.class.getResource("/images/ranged2down.png"));

		Super1down = ImageIO.read(Board.class.getResource("/images/super1down.png"));
		Medic1down = ImageIO.read(Board.class.getResource("/images/medic1down.png"));
		tech1down = ImageIO.read(Board.class.getResource("/images/tech1down.png"));
		Ranged1down = ImageIO.read(Board.class.getResource("/images/ranged1down.png"));

		Super2glowdown = ImageIO.read(Board.class.getResource("/images/super2glowdown.png"));
		Medic2glowdown = ImageIO.read(Board.class.getResource("/images/medic2glowdown.png"));
		Tech2glowdown = ImageIO.read(Board.class.getResource("/images/tech2glowdown.png"));
		Ranged2glowdown = ImageIO.read(Board.class.getResource("/images/ranged2glowdown.png"));

		Super1glowdown = ImageIO.read(Board.class.getResource("/images/super1glowdown.png"));
		Medic1glowdown = ImageIO.read(Board.class.getResource("/images/medic1glowdown.png"));
		Tech1glowdown = ImageIO.read(Board.class.getResource("/images/tech1glowdown.png"));
		Ranged1glowdown = ImageIO.read(Board.class.getResource("/images/ranged1glowdown.png"));

		SideKickP1glow = ImageIO.read(Board.class.getResource("/images/sidekick1glow.png"));
		SideKickP2glow = ImageIO.read(Board.class.getResource("/images/sidekick2glow.png"));
		Super1glow = ImageIO.read(Board.class.getResource("/images/super1glow.png"));
		Medic1glow = ImageIO.read(Board.class.getResource("/images/medic1glow.png"));
		Speedster1glow = ImageIO.read(Board.class.getResource("/images/speedster1glow.png"));
		Armored1glow = ImageIO.read(Board.class.getResource("/images/armor1glow.png"));

		Armored1downglow = ImageIO.read(Board.class.getResource("/images/armordown1glow.png"));
		Tech1glow = ImageIO.read(Board.class.getResource("/images/tech1glow.png"));
		Ranged1glow = ImageIO.read(Board.class.getResource("/images/ranged1glow.png"));

		Super2glow = ImageIO.read(Board.class.getResource("/images/super2glow.png"));
		Medic2glow = ImageIO.read(Board.class.getResource("/images/medic2glow.png"));
		Speedster2glow = ImageIO.read(Board.class.getResource("/images/speedster2glow.png"));
		Armored2glow = ImageIO.read(Board.class.getResource("/images/armor2glow.png"));
		Armored2downglow = ImageIO.read(Board.class.getResource("/images/armordown2glow.png"));
		tech2glow = ImageIO.read(Board.class.getResource("/images/tech2glow.png"));
		Ranged2glow = ImageIO.read(Board.class.getResource("/images/ranged2glow.png"));

		SideKickp1i = ImageIO.read(Board.class.getResource("/images/sidekick1.png"));
		SideKickp2i = ImageIO.read(Board.class.getResource("/images/sidekick2.png"));

		Super1i = ImageIO.read(Board.class.getResource("/images/super1.png"));
		Medic1i = ImageIO.read(Board.class.getResource("/images/medic1.png"));
		Speedster1i = ImageIO.read(Board.class.getResource("/images/speedster1.png"));
		Armored1i = ImageIO.read(Board.class.getResource("/images/armor1.png"));
		Tech1i = ImageIO.read(Board.class.getResource("/images/tech1.png"));
		Ranged1i = ImageIO.read(Board.class.getResource("/images/ranged1.png"));
		Armored1downi = ImageIO.read(Board.class.getResource("/images/armordown1.png"));
		Armored2downi = ImageIO.read(Board.class.getResource("/images/armordown2.png"));

		Super2i = ImageIO.read(Board.class.getResource("/images/super2.png"));
		Medic2i = ImageIO.read(Board.class.getResource("/images/medic2.png"));
		Speedster2i = ImageIO.read(Board.class.getResource("/images/speedster2.png"));
		Armored2i = ImageIO.read(Board.class.getResource("/images/armor2.png"));
		Tech2i = ImageIO.read(Board.class.getResource("/images/tech2.png"));
		Ranged2i = ImageIO.read(Board.class.getResource("/images/ranged2.png"));

	}
	// public static void refresh() {
	// glow();

	// for (int i = 0; i < 7; i++) {
	// for (int j = 0; j < 6; j++) {
	// if (game.getCellAt(i, j).getPiece()==null)
	// {chessBoard.getComponent(i*6+j);

	// }
	public void end() {
		chessBoard.removeMouseListener(this);
		chessBoard.removeMouseMotionListener(this);
	}

	public static void won() {
		String x;
		if (game.getCurrentPlayer() == game.getPlayer1())
			x = p1;
		else {
			x = p2;
		}
		JOptionPane.showMessageDialog(null, x + " has won", "Game ended ", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void glow() {

		try {
			updatepayload();

		} catch (IOException e1) {
			// TODO Auto-generated catch block

		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (game.getCellAt(i, j).getPiece() != null) {
					if (game.getCellAt(i, j).getPiece().getOwner() == game.getPlayer2()) {
						alive2.add(game.getCellAt(i, j).getPiece());

					}

				}
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (game.getCellAt(i, j).getPiece() != null) {
					if (game.getCellAt(i, j).getPiece().getOwner() == game.getCurrentPlayer()) {
						try {
							piece = getresglow(game.getCellAt(i, j).getPiece());
						} catch (IOException e) {
							// TODO Auto-generated catch block
						}
						panel = (JPanel) chessBoard.getComponent(i * 6 + j);
						if (panel.getComponentCount() != 0)
							panel.removeAll();
						panel.add(piece);
						MouseListener xd4;

						chessBoard.revalidate();
						chessBoard.repaint();

					}
					if (game.getCellAt(i, j).getPiece().getOwner() != game.getCurrentPlayer()) {
						try {
							piece = getres(game.getCellAt(i, j).getPiece());

						} catch (IOException e) {
							// TODO Auto-generated catch block
						}
						panel = (JPanel) chessBoard.getComponent(i * 6 + j);
						if (panel.getComponentCount() > 0)
							panel.removeAll();

						panel.add(piece);
						chessBoard.repaint();
						chessBoard.revalidate();

					}

				}
				if (game.getCellAt(i, j).getPiece() == null) {
					panel = (JPanel) chessBoard.getComponent(i * 6 + j);
					panel.removeAll();
					chessBoard.repaint();
					chessBoard.revalidate();

				}
			}

		}
		
		
		
		Image image2 = null;
		try {
			image2 = ImageIO.read(Board.class.getResource("/images/grave.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		graveyard1.removeAll();

		for (int i = 0; i < 20; i++) {
			BackgroundPanel square = new BackgroundPanel(image2);
			square.getImage();
			graveyard1.add(square);

		}
		
		
		for (int i = 0; i < game.getPlayer1().getDeadCharacters().size(); i++) {

			try {
				piece = getres(game.getPlayer1().getDeadCharacters().get(i), 40, 45);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}

			panel = (JPanel) graveyard1.getComponent(i);
			panel.add(piece);
			panel.revalidate();
			panel.repaint();
		}
		
		
		try {
			image2 = ImageIO.read(Board.class.getResource("/images/grave.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		graveyard2.removeAll();
		for (int i = 0; i < 20; i++) {
			BackgroundPanel square = new BackgroundPanel(image2);
			square.getImage();
			graveyard2.add(square);

		}

		for (int i = 0; i < game.getPlayer2().getDeadCharacters().size(); i++) {

			try {
				piece = getres(game.getPlayer2().getDeadCharacters().get(i), 40, 45);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}

			panel = (JPanel) graveyard2.getComponent(i);
			panel.add(piece);
			panel.revalidate();
			panel.repaint();
		}
	}

	private static Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	public static JLabel getres(Piece newp, int w, int h) throws IOException {
		String urp = null;
		Object i;
		Image image = null;
		if (newp instanceof SideKickP1)
			image = SideKickp1i;
		if (newp instanceof SideKickP2)
			image = SideKickp2i;

		if (newp instanceof Super && newp.getOwner() == game.getPlayer1())
			image = Super1i;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer1())
			image = Medic1i;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer1())
			image = Speedster1i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer1())
			image = Armored1i;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer1())
			image = Tech1i;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer1())
			image = Ranged1i;

		if (newp instanceof Super && newp.getOwner() == game.getPlayer2())
			image = Super2i;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2())
			image = Medic2i;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer2())
			image = Speedster2i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer2())
			image = Armored2i;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2())
			image = Tech2i;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2())
			image = Ranged2i;

		ImageIcon chessp = new ImageIcon(getScaledImage(image, w, h));

		JLabel piece = new JLabel(chessp);
		return piece;
	}

	public static void updatepayload() throws IOException {
		BackgroundPanel payload2x = null;
		BackgroundPanel payload1x = null;
		top.repaint();

		if (game.getPlayer1().getPayloadPos() == 0) {
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/barin.png")));
			top.repaint();
			payload1.add(payload1x);
			top.repaint();
		}

		if (game.getPlayer1().getPayloadPos() == 1)
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/1.png")));
		if (game.getPlayer1().getPayloadPos() == 2)
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/2.png")));
		if (game.getPlayer1().getPayloadPos() == 3)
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/3.png")));
		if (game.getPlayer1().getPayloadPos() == 4)
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/4.png")));
		if (game.getPlayer1().getPayloadPos() == 5)
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/5.png")));
		if (game.getPlayer1().getPayloadPos() == 6) {
			payload1x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/6.png")));
			gameended = true;
			payload1.remove(0);
			top.repaint();

			payload2.remove(0);
			top.repaint();

			payload1.add(payload1x);
			top.repaint();

		}

		if (game.getPlayer2().getPayloadPos() == 0) {
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/bar.png")));
			top.repaint();
			payload2.add(payload2x);
			top.repaint();

		}

		if (game.getPlayer2().getPayloadPos() == 1)
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/1in.png")));
		if (game.getPlayer2().getPayloadPos() == 2)
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/2in.png")));
		if (game.getPlayer2().getPayloadPos() == 3)
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/3in.png")));
		if (game.getPlayer2().getPayloadPos() == 4)
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/4in.png")));
		if (game.getPlayer2().getPayloadPos() == 5)
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/5in.png")));
		if (game.getPlayer2().getPayloadPos() == 6) {
			payload2x = new BackgroundPanel(ImageIO.read(Board.class.getResource("/images/6in.png")));
			gameended = true;

			payload1.remove(0);
			payload2.remove(0);
			payload2.add(payload2x);
			top.repaint();

			Player x;
			if (game.getCurrentPlayer() == game.getPlayer1())
				x = game.getPlayer2();
			else
				x = game.getPlayer1();

			if (game.getCurrentPlayer() == game.getPlayer1())
				x = game.getPlayer2();
			else
				x = game.getPlayer1();

		}
		if (payload1.getComponentCount() > 0)
			payload1.remove(0);
		if (payload2.getComponentCount() > 0)
			payload2.remove(0);
		payload1.add(payload1x);
		top.repaint();

		payload2.add(payload2x);
		top.repaint();

		top.repaint();
	}

	public static JLabel getresglow(Piece newp) throws IOException {

		Image image = null;

		if (newp instanceof SideKickP1)
			image = SideKickP1glow;
		if (newp instanceof SideKickP2)
			image = SideKickP2glow;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer1())
			image = Super1glow;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer1())
			image = Medic1glow;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer1())
			image = Speedster1glow;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer1() && ((Armored) newp).isArmorUp() == true)
			image = Armored1glow;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer1() && ((Armored) newp).isArmorUp() == false)
			image = Armored1downglow;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer1())
			image = Tech1glow;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer1())
			image = Ranged1glow;

		if (newp instanceof Tech && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Tech1glowdown;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Medic1glowdown;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Super1glowdown;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Ranged1glowdown;

		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Tech2glowdown;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Medic2glowdown;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Super2glowdown;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Ranged2glowdown;

		if (newp instanceof Super && newp.getOwner() == game.getPlayer2())
			image = Super2glow;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2())
			image = Medic2glow;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer2())
			image = Speedster2glow;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer2() && ((Armored) newp).isArmorUp() == true)
			image = Armored2glow;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer2() && ((Armored) newp).isArmorUp() == false)
			image = Armored2downglow;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2())
			image = tech2glow;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2())
			image = Ranged2glow;

		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Tech2glowdown;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Medic2glowdown;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Super2glowdown;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Ranged2glowdown;

		ImageIcon chessp = new ImageIcon(image);

		JLabel piece = new JLabel(chessp);
		return piece;
	}

	public static JLabel getres(Piece newp) throws IOException {
		String urp = null;
		Object i;
		Image image = null;

		if (newp instanceof SideKickP1)
			image = SideKickp1i;
		if (newp instanceof SideKickP2)
			image = SideKickp2i;

		if (newp instanceof Super && newp.getOwner() == game.getPlayer1())
			image = Super1i;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer1())
			image = Medic1i;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer1())
			image = Speedster1i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer1() && ((Armored) newp).isArmorUp() == true)
			image = Armored1i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer1() && ((Armored) newp).isArmorUp() == false)
			image = Armored1downi;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer1())
			image = Tech1i;

		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer1())
			image = Ranged1i;

		if (newp instanceof Super && newp.getOwner() == game.getPlayer2())
			image = Super2i;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2())
			image = Medic2i;
		if (newp instanceof Speedster && newp.getOwner() == game.getPlayer2())
			image = Speedster2i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer2() && ((Armored) newp).isArmorUp() == true)
			image = Armored2i;
		if (newp instanceof Armored && newp.getOwner() == game.getPlayer2() && ((Armored) newp).isArmorUp() == false)
			image = Armored2downi;
		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2())
			image = Tech2i;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2())
			image = Ranged2i;

		if (newp instanceof Tech && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = tech1down;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Medic1down;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Super1down;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer1()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Ranged1down;

		if (newp instanceof Tech && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = tech2down;
		if (newp instanceof Medic && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Medic2down;
		if (newp instanceof Super && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Super2down;
		if (newp instanceof Ranged && newp.getOwner() == game.getPlayer2()
				&& ((ActivatablePowerHero) newp).isPowerUsed() == true)
			image = Ranged2down;

		ImageIcon chessp = new ImageIcon(image); // add an image here

		JLabel piece = new JLabel(chessp);
		return piece;
	}

	Component clicked;
	Point newPos = new Point();
	static JLabel piece;
	MouseListener xd;
	Piece curr;
	int which;
	int addy;
	int addx;
	JPanel wgrave;

	public void listengrave2(Medic curr) {

		graveyard2.addMouseListener(xd = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				c1 = graveyard2.findComponentAt(e.getX(), e.getY());
				cordJorig = c1.getParent().getX();
				cordIorig = c1.getParent().getY();

				addx = cordJorig / 60;
				if (cordIorig == 50)
					addy = 10;
				else
					addy = 0;
				which = addx + addy;

				if (which >= game.getCurrentPlayer().getDeadCharacters().size()) {
					target = null;
				} else {
					target = game.getCurrentPlayer().getDeadCharacters().get(which);
					c1 = graveyard2.findComponentAt(e.getX(), e.getY());
					clicked = c1;
				}
			}

			Boolean found = false;

			@Override
			public void mouseReleased(MouseEvent e)

			{
				int clickx = e.getX();
				int clicky = e.getY();

				c1 = chessBoard.findComponentAt(clickx, clicky - 125);
				int aJ = 0;
				int aI = 0;
				if (c1 == null) {
					JOptionPane.showMessageDialog(null, "invalid target", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					cordJorig = c1.getX();
					cordIorig = c1.getY();
					if (cordJorig == 0)
						aJ = 0;
					if (cordJorig != 0)
						aJ = cordJorig / 100;

					if (cordIorig == 2)
						aI = 0;
					if (cordIorig == 87)
						aI = 1;
					if (cordIorig == 172)
						aI = 2;
					if (cordIorig == 257)
						aI = 3;
					if (cordIorig == 342)
						aI = 4;
					if (cordIorig == 427)
						aI = 5;
					if (cordIorig == 512)
						aI = 6;
					Point newPos = new Point(aI, aJ);
				}
				if (target == null)
					JOptionPane.showMessageDialog(null, "invalid target", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					panel = (JPanel) chessBoard.getComponent(aI * 6 + aJ);
					try {
						piece = getres(target);
					} catch (IOException e1) {
						// TODO Auto-generated catch block

					}
					for (int i = 0; i < radius.size(); i++) {
						if (aI * 6 + aJ == radius.get(i)) {
							found = true;
							try {
								Point xn = new Point(radiusI.get(i), radiusJ.get(i));
								curr.usePower(MedicDir.get(i), target, xn);
								break;
							} catch (InvalidPowerUseException e1) {
								JOptionPane.showMessageDialog(null, "Invalid revive pos", "InfoBox: " + "error",
										JOptionPane.INFORMATION_MESSAGE);
								found = false;
							} catch (WrongTurnException e1) {
								// TODO Auto-generated catch block

							}

						}
					}

					if (found == false) {
						JOptionPane.showMessageDialog(null, "Invalid revive pos", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						try {
							piece = getres(target, 40, 45);
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
						panel = (JPanel) graveyard2.getComponent(which);
						panel.add(piece);

						setCursor(null);
						clicked.setVisible(false);
					} else {
						panel.add(piece);
						setCursor(null);

						// Make sure the chess piece is no longer painted on the layered pane

						clicked.setVisible(false);
						// graveyard1.remove(clicked);
						piece.setVisible(true);
					}
					for (int i = 0; i < radius.size(); i++) {
						cleanMedic.add(radius.get(i));

					}
					Image image1 = null;
					try {
						image1 = ImageIO.read(getClass().getResource("/images/brick.png"));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
					}

					for (int i = 0; i < cleanMedic.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(cleanMedic.get(i));
						square.setImage(image1);

					}

					radius.clear();
					radiusI.clear();
					radiusJ.clear();
					MedicDir.clear();
					delistengrave2();
				}
			}

			private void delistengrave2() {
				graveyard2.removeMouseListener(xd);
				graveyard2.removeMouseMotionListener(xd2);

			}

		});

		graveyard2.addMouseMotionListener(xd2 = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (clicked == null)
					return;
				clicked.setLocation(e.getX(), e.getY());
				add(clicked, JLayeredPane.DRAG_LAYER);
				setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

			}
		});
	}

	public void listengrave(Medic curr) {

		graveyard1.addMouseListener(xd = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				c1 = graveyard1.findComponentAt(e.getX(), e.getY());
				cordJorig = c1.getParent().getX();
				cordIorig = c1.getParent().getY();

				addx = cordJorig / 60;
				if (cordIorig == 50)
					addy = 10;
				else
					addy = 0;
				which = addx + addy;

				if (which >= game.getCurrentPlayer().getDeadCharacters().size()) {
					target = null;
				} else {
					target = game.getCurrentPlayer().getDeadCharacters().get(which);
					c1 = graveyard1.findComponentAt(e.getX(), e.getY());
					clicked = c1;
				}
			}

			Boolean found = false;

			@Override
			public void mouseReleased(MouseEvent e)

			{
				if (gameended == true)
					return;
				int clickx = e.getX();
				int clicky = e.getY();

				c1 = chessBoard.findComponentAt(clickx, clicky + 600);
				int aJ = 0;
				int aI = 0;
				if (c1 == null) {
					JOptionPane.showMessageDialog(null, "invalid target", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					cordJorig = c1.getX();
					cordIorig = c1.getY();

					if (cordJorig == 0)
						aJ = 0;
					if (cordJorig != 0)
						aJ = cordJorig / 100;

					if (cordIorig == 2)
						aI = 0;
					if (cordIorig == 87)
						aI = 1;
					if (cordIorig == 172)
						aI = 2;
					if (cordIorig == 257)
						aI = 3;
					if (cordIorig == 342)
						aI = 4;
					if (cordIorig == 427)
						aI = 5;
					if (cordIorig == 512)
						aI = 6;
					Point newPos = new Point(aI, aJ);
				}
				if (target == null)
					JOptionPane.showMessageDialog(null, "invalid target", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					panel = (JPanel) chessBoard.getComponent(aI * 6 + aJ);
					try {
						piece = getres(target);
					} catch (IOException e1) {
						// TODO Auto-generated catch block

					}
					for (int i = 0; i < radius.size(); i++) {
						if (aI * 6 + aJ == radius.get(i)) {
							found = true;
							try {
								Point xn = new Point(radiusI.get(i), radiusJ.get(i));
								curr.usePower(MedicDir.get(i), target, xn);
								break;
							} catch (InvalidPowerUseException e1) {
								JOptionPane.showMessageDialog(null, "Invalid revive pos", "InfoBox: " + "error",
										JOptionPane.INFORMATION_MESSAGE);
								found = false;
							} catch (WrongTurnException e1) {
								// TODO Auto-generated catch block

							}

						}
					}

					if (found == false) {
						JOptionPane.showMessageDialog(null, "Invalid revive pos", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						try {
							piece = getres(target, 40, 45);
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
						panel = (JPanel) graveyard1.getComponent(which);
						panel.add(piece);

						setCursor(null);
						clicked.setVisible(false);
					} else {
						panel.add(piece);
						setCursor(null);

						// Make sure the chess piece is no longer painted on the layered pane

						clicked.setVisible(false);
						// graveyard1.remove(clicked);
						piece.setVisible(true);
					}
					for (int i = 0; i < radius.size(); i++) {
						cleanMedic.add(radius.get(i));

					}
					Image image1 = null;
					try {
						image1 = ImageIO.read(getClass().getResource("/images/brick.png"));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
					}

					for (int i = 0; i < cleanMedic.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(cleanMedic.get(i));
						square.setImage(image1);

					}

					radius.clear();
					radiusI.clear();
					radiusJ.clear();
					MedicDir.clear();
					delistengrave();
				}
			}

		});

		graveyard1.addMouseMotionListener(xd2 = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (clicked == null)
					return;
				clicked.setLocation(e.getX(), e.getY() + 725);
				add(clicked, JLayeredPane.DRAG_LAYER);
				setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

			}
		});
	}

	public void delistengrave() {

		graveyard1.removeMouseListener(xd);
		graveyard1.removeMouseMotionListener(xd2);

	}

	public static final int getComponentIndex(Component component) {
		if (component != null && component.getParent() != null) {
			Container c = component.getParent();
			for (int i = 0; i < c.getComponentCount(); i++) {
				if (c.getComponent(i) == component)
					return i;
			}
		}

		return -1;
	}

	public Board(Game g) throws IOException {

		setPreferredSize(boardSize);

		// Add a chess board to the Layered Pane

		chessBoard = new JPanel();
		chessBoard.setLayout(new GridLayout(7, 6));
		chessBoard.setPreferredSize(boardSize1);
		chessBoard.setBounds(25, 150, boardSize1.width, boardSize1.height);
		chessBoard.addMouseListener(this);
		chessBoard.addMouseMotionListener(this);
		chessBoard.setBackground(Color.decode("#40382f"));

		starpanel = new JPanel();
		starpanel.setLayout(new GridLayout(7, 6));
		starpanel.setPreferredSize(boardSize1);
		starpanel.setBounds(25, 150, boardSize1.width, boardSize1.height);
		starpanel.setOpaque(false);

		// starpanel.setBackground( new Color(10,10,10,10) );
		// starpanel.addMouseListener(this);
		// chessBoard.addMouseMotionListener(this);
		// chessBoard.setBackground(Color.decode("#40382f"));

		payload1 = new BackgroundPanel(ImageIO.read(getClass().getResource("/images/barin.png")));
		payload1.setLayout(new GridLayout(1, 1));
		payload1.setPreferredSize(payloadsize);
		payload1.setBounds(625, 50, payloadsize.width, payloadsize.height);
		payload1.setVisible(true);

		payload2 = new BackgroundPanel(ImageIO.read(getClass().getResource("/images/bar.png")));
		payload2.setLayout(new GridLayout(1, 1));
		payload2.setPreferredSize(payloadsize);
		payload2.setBounds(0, 50, payloadsize.width, payloadsize.height);
		payload2.setVisible(true);

		bottom = new BackgroundPanel(ImageIO.read(getClass().getResource("/images/bottom.png")));
		bottom.setLayout(new GridLayout(1, 1));
		bottom.setPreferredSize(bottomsize);
		bottom.setBounds(0, 800, bottomsize.width, bottomsize.height);
		bottom.setVisible(true);

		top = new BackgroundPanel(ImageIO.read(getClass().getResource("/images/top.png")));
		top.setLayout(new GridLayout(1, 1));
		top.setPreferredSize(topsize);
		top.setBounds(0, 0, topsize.width, 55);
		top.setVisible(true);

		// 0-100 payload
		graveyard1 = new JPanel();
		graveyard1.setLayout(new GridLayout(2, 1));
		graveyard1.setPreferredSize(gravesize);
		graveyard1.setBounds(25, 750, gravesize.width, gravesize.height);
		graveyard1.setVisible(true);
		Image image2 = ImageIO.read(getClass().getResource("/images/grave.png"));

		for (int i = 0; i < 20; i++) {
			BackgroundPanel square = new BackgroundPanel(image2);
			square.getImage();
			graveyard1.add(square);

		}

		graveyard2 = new JPanel();
		graveyard2.setLayout(new GridLayout(2, 1));
		graveyard2.setPreferredSize(gravesize);
		graveyard2.setBounds(25, 50, gravesize.width, gravesize.height);
		graveyard2.setVisible(true);
		Image image3 = ImageIO.read(getClass().getResource("/images/grave.png"));

		for (int i = 0; i < 20; i++) {
			BackgroundPanel square = new BackgroundPanel(image3);

			graveyard2.add(square);

		}

		add(player1f, JLayeredPane.DEFAULT_LAYER);
		add(player2f, JLayeredPane.DEFAULT_LAYER);
		add(graveyard1, JLayeredPane.DEFAULT_LAYER);
		add(graveyard2, JLayeredPane.DEFAULT_LAYER);
		add(top, JLayeredPane.DEFAULT_LAYER);
		add(payload1, JLayeredPane.DEFAULT_LAYER);
		add(payload2, JLayeredPane.DEFAULT_LAYER);

		add(bottom, JLayeredPane.DEFAULT_LAYER);
		add(chessBoard, JBorderLayout, 300);
		// Build the Chess Board squares

		Image image1 = ImageIO.read(getClass().getResource("/images/brick.png"));

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				BackgroundPanel square = new BackgroundPanel(image1);

				chessBoard.add(square);
				// square.addMouseListener(this);
				// square.addMouseMotionListener(this);

			}

		}

		// Add a few pieces to the board
		JLabel piece;
		glow();
	}

	int origI;
	int origJ;
	int newI;
	int newJ;

	/*
	 ** Add the selected chess piece to the dragging layer so it can be moved
	 */
	public void storeOrig(int i, int j) {
		origI = i;
		origJ = j;
	}

	public boolean storeNew(int i, int j, Direction d) throws IOException {

		updatepayload();

		newI = i;
		newJ = j;
		int i1;
		int j1;
		Piece curr = game.getCellAt(origI, origJ).getPiece();
		Piece newp = game.getCellAt(newI, newJ).getPiece();

		if (curr != null)
			if (curr.getOwner() != game.getCurrentPlayer()) {
				JOptionPane.showMessageDialog(null, "wrong turn", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

		if (newp != null && curr != null)
			if (newp == curr)
				return false;
		Image image = null;
		boolean wasArmor = false;
		if (newp != null)
			if (newp instanceof Hero)
				if (newp instanceof NonActivatablePowerHero)
					if (newp instanceof Armored)
						if (((Armored) newp).isArmorUp() == true) {
							wasArmor = true;
							panel = (JPanel) chessBoard.getComponent((newp.getPosI() * 6 + newp.getPosJ()));
							if (newp.getOwner() == game.getPlayer1())
								image = ImageIO.read(getClass().getResource("/images/armordown1.png"));
							if (newp.getOwner() == game.getPlayer2())
								image = ImageIO.read(getClass().getResource("/images/armordown2.png"));
							ImageIcon chessp = new ImageIcon(image); // add an image here
							JLabel piece = new JLabel(chessp);
							panel.remove(0);
							panel.add(piece);

						}
		if (curr instanceof SideKick)
			if (newp != null)
				if (newp.getOwner() != curr.getOwner())
					if (newp instanceof Hero && wasArmor == false) {

						zombie = true;

						// Add a few pieces to the board
						i1 = newp.getPosI();
						j1 = newp.getPosJ();
						if (game.getCellAt(newp.getPosI(), j1).getPiece() != null) {

							JLabel piece = getres(game.getCellAt(newp.getPosI(), j1).getPiece());
							j1 = newp.getPosJ();

							if (i1 == 0)
								i1 = 0;
							if (i1 != 0)
								i1 = i1 * 6;

							String urp1 = null;
							JLabel piece1 = getres(game.getCellAt(newI, newJ).getPiece());

							int pos = 0;
							int pos1 = newJ - 1;
							if (newI == 0)
								pos = 0;
							if (newI != 0)
								pos = newI * 6;

							pos1 = newI;
							JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);

							// panel.add(piece1);

						}
					}

		if (d == Direction.UP) {
			try {
				curr.moveUp();
				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);

					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}

				}
				if (wasArmor == true)
					return false;
				else {
					updatepayload();

					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "occupied cell", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		}

		if (d == Direction.DOWN) {
			try {
				curr.moveDown();
				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);

					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}

				}
				if (wasArmor == true)
					return false;
				else {
					updatepayload();
					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "occupied cell", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		}

		if (d == Direction.RIGHT)
			try {
				curr.moveRight();

				JLabel piece = getres(newp, 40, 45);
				if (newp != null) {
					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}

					if (wasArmor == true)
						return false;
					else {
						updatepayload();
						return true;
					}
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		if (d == Direction.LEFT)
			try {
				curr.moveLeft();
				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);

					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}
				}

				if (wasArmor == true)
					return false;
				else {
					updatepayload();
					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		if (d == Direction.UPRIGHT)
			try {
				curr.moveUpRight();

				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);

					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}
				}

				if (wasArmor == true)
					return false;
				else {
					updatepayload();
					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		if (d == Direction.UPLEFT)
			try {
				curr.moveUpLeft();

				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);

					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}
				}

				if (wasArmor == true)
					return false;
				else {
					updatepayload();
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		if (d == Direction.DOWNLEFT)
			try {
				curr.moveDownLeft();

				if (newp != null) {
					JLabel piece = getres(newp, 40, 45);
					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}
				}

				if (wasArmor == true)
					return false;
				else {
					updatepayload();
					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}
		if (d == Direction.DOWNRIGHT)
			try {

				curr.moveDownRight();

				JLabel piece = getres(newp, 40, 45);
				if (newp != null) {
					if (newp.getOwner() == game.getPlayer1()) {
						panel = (JPanel) graveyard1.getComponent(counter);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter++;
							}
						} else {
							// panel.add(piece);
							// counter++;
						}
					}

					if (newp.getOwner() == game.getPlayer2()) {
						panel = (JPanel) graveyard2.getComponent(counter2);
						if (newp instanceof Armored) {
							if (wasArmor == false) {
								// panel.add(piece);
								// counter2++;
							}
						} else {
							// panel.add(piece);
							// counter2++;
						}
					}

				}

				if (wasArmor == true)
					return false;
				else {
					updatepayload();
					return true;
				}
			} catch (UnallowedMovementException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (OccupiedCellException e) {
				JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} catch (WrongTurnException e) {
				return false;
			}

		if (wasArmor == true)
			return false;

		return true;

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (gameended == true)
			return;
		if (SwingUtilities.isLeftMouseButton(e)) {

			int clickx = e.getX();
			int clicky = e.getY();
			int cordJ = 0;
			int cordI = 0;
			int aI = 0;
			int aJ = 0;
			c1 = chessBoard.findComponentAt(e.getX(), e.getY());

			cordJorig = chessBoard.getComponentAt(e.getX(), e.getY()).getX();
			cordIorig = chessBoard.getComponentAt(e.getX(), e.getY()).getY();

			if (cordJorig == 0)
				aJ = 0;
			if (cordJorig != 0)
				aJ = cordJorig / 100;

			if (cordIorig == 2)
				aI = 0;
			if (cordIorig == 87)
				aI = 1;
			if (cordIorig == 172)
				aI = 2;
			if (cordIorig == 257)
				aI = 3;
			if (cordIorig == 342)
				aI = 4;
			if (cordIorig == 427)
				aI = 5;
			if (cordIorig == 512)
				aI = 6;
			Direction arrow = null;
			if (superclick == true) {

				int indexi;
				int indexj;
				Direction superd = null;
				if (game.getCellAt(aI, aJ).getPiece() != null) {
					for (int i = 0; i < superradius.size(); i++) {
						if (aI * 6 + aJ == superradius.get(i)) {
							indexi = superI.get(i);
							indexj = superJ.get(i);
							superd = superdir.get(i);
						}
					}
					if (game.getCellAt(aI, aJ).getPiece().getOwner() == Super1.getOwner()) {
						JOptionPane.showMessageDialog(null, "Invalid target", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						superclick = false;

						for (int i = 0; i < superradius.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(superradius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}
						}

						superradius.clear();
						superI.clear();
						superJ.clear();
						return;
					}
					try {
						if (superd == null)
							superd = Direction.DOWNLEFT;
						Super1.usePower(superd, null, null);
					} catch (InvalidPowerUseException e1) {
						JOptionPane.showMessageDialog(null, "Invalid target", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						superclick = false;
					} catch (WrongTurnException e1) {
						// TODO Auto-generated catch block

					}
				}

				for (int i = 0; i < superradius.size(); i++) {
					BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(superradius.get(i));
					try {
						square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
					} catch (IOException e1) {
						// TODO Auto-generated catch block

					}
				}

				superradius.clear();
				superI.clear();
				superJ.clear();

				superclick = false;
				return;
			}
			if (rangedclick == true) {

				if (game.getCellAt(aI, aJ).getPiece() != null) {
					if (Rangeddowntarget != null)
						if (game.getCellAt(aI, aJ).getPiece() == Rangeddowntarget) {
							arrow = Direction.DOWN;
						}
					if (Rangeduptarget != null)
						if (game.getCellAt(aI, aJ).getPiece() == Rangeduptarget) {
							arrow = Direction.UP;
						}
					if (Rangedrighttarget != null)
						if (game.getCellAt(aI, aJ).getPiece() == Rangedrighttarget) {
							arrow = Direction.RIGHT;
						}
					if (Rangedlefttarget != null)
						if (game.getCellAt(aI, aJ).getPiece() == Rangedlefttarget) {
							arrow = Direction.LEFT;
						}
				}
				try {
					if (arrow != null) {
						Ranged1.usePower(arrow, game.getCellAt(aI, aJ).getPiece(), null);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid target", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
					}
					for (int i = 0; i < rangedbluedown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedbluedown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedbluedown.clear();

					for (int i = 0; i < rangedgreendown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreendown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreendown.clear();
					for (int i = 0; i < rangedreddown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedreddown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedreddown.clear();
					for (int i = 0; i < rangedblueup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueup.clear();

					for (int i = 0; i < rangedgreenup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenup.clear();
					for (int i = 0; i < rangedredup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredup.clear();
					for (int i = 0; i < rangedblueright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueright.clear();

					for (int i = 0; i < rangedgreenright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenright.clear();
					for (int i = 0; i < rangedredright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredright.clear();
					for (int i = 0; i < rangedblueleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueleft.clear();

					for (int i = 0; i < rangedgreenleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenleft.clear();
					for (int i = 0; i < rangedredleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredleft.clear();

				} catch (InvalidPowerUseException e1) {
					// TODO Auto-generated catch block

				} catch (WrongTurnException e1) {
					// TODO Auto-generated catch block

				}
				rangedclick = false;
				// rangeddrag = true;
				// rangedrelease = true;
				return;
			}
			if (techclick == true) {

				techrelease = true;
				techdrag = true;
				if (game.getCellAt(aI, aJ).getPiece() == null) {
					empty = true;
					techclick = false;
					return;
				}

				else if (game.getCellAt(aI, aJ).getPiece().getOwner() == tech1.getOwner()) {

					c1 = chessBoard.findComponentAt(e.getX(), e.getY());
					clicked = c1;

					techtarget = game.getCellAt(aI, aJ).getPiece();
					techclick = false;

				}

				return;

			}
			if (techclick2 == true) {
				techrelease2 = true;
				techdrag2 = true;
				if (game.getCellAt(aI, aJ).getPiece() == null) {
					empty = true;
					techclick2 = false;
					return;
				}

				else if (game.getCellAt(aI, aJ).getPiece() != null) {

					c1 = chessBoard.findComponentAt(e.getX(), e.getY());
					clicked = c1;
					boolean found = false;
					techtarget2 = game.getCellAt(aI, aJ).getPiece();
					for (int i = 0; i < techblue.size(); i++) {
						if (aI * 6 + aJ == techblue.get(i))
							found = true;
					}
					for (int i = 0; i < techgreen.size(); i++) {
						if (aI * 6 + aJ == techgreen.get(i))
							found = true;
					}
					try {
						if (found == true)
							tech1.usePower(null, techtarget2, null);
						techclick = false;
						techclick2 = false;
					} catch (InvalidPowerUseException e1) {
						JOptionPane.showMessageDialog(null, "Invalid target", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						techclick2 = false;
						return;
					} catch (WrongTurnException e1) {
						// TODO Auto-generated catch block

					}
					if (found == false) {
						JOptionPane.showMessageDialog(null, "Invalid target", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						for (int i = 0; i < techred.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techred.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techblue.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techblue.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techgreen.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techgreen.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						techclickcount = 0;
						techclick = false;
						techclick2 = false;
						techdrag2 = false;
						techrelease2 = false;

					}

				}

				return;

			}
			if (game.getCellAt(aI, aJ).getPiece() == null) {
				empty = true;
				return;
			}

			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof Medic
					|| game.getCellAt(aI, aJ).getPiece() instanceof Super) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();

				// up
				int newX = posI - 1;

				if (newX < 0) {
					newX = game.getBoardHeight() - 1;
				}
				radiusI.add(newX);
				radiusJ.add(posJ);
				radius.add(newX * 6 + posJ);
				// down
				int newX1 = posI + 1;

				if (newX1 == game.getBoardHeight()) {
					newX1 = 0;
				}
				radiusI.add(newX1);
				radiusJ.add(posJ);
				radius.add(newX1 * 6 + posJ);

				// left
				int newY1 = posJ - 1;

				if (newY1 < 0) {
					newY1 = game.getBoardWidth() - 1;
				}

				radiusI.add(posI);
				radiusJ.add(newY1);
				radius.add(posI * 6 + newY1);

				int newY = posJ + 1;
				// right
				if (newY == game.getBoardWidth()) {
					newY = 0;
				}
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);
				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);

				for (int i = 0; i < radius.size() - 1; i++) {
					if (i == 0) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(0));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}
						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

			}

			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof SideKickP1) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				// down
				int newX = posI - 1;

				if (newX < 0) {
					newX = game.getBoardHeight() - 1;
				}
				radiusI.add(newX);
				radiusJ.add(posJ);
				radius.add(newX * 6 + posJ);

				// left
				int newY1 = posJ - 1;

				if (newY1 < 0) {
					newY1 = game.getBoardWidth() - 1;
				}

				radiusI.add(posI);
				radiusJ.add(newY1);
				radius.add(posI * 6 + newY1);

				int newY = posJ + 1;
				// right
				if (newY == game.getBoardWidth()) {
					newY = 0;
				}
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);

				// upright

				int newX11 = posI - 1;
				int newY11 = posJ + 1;

				if (newX11 < 0) {
					newX11 = game.getBoardHeight() - 1;
				}

				if (newY11 == game.getBoardWidth()) {
					newY11 = 0;
				}
				radiusI.add(newX11);
				radiusJ.add(newY11);
				radius.add(newX11 * 6 + newY11);

				// upleft
				int newX111 = posI - 1;
				int newY111 = posJ - 1;

				if (newX111 < 0) {
					newX111 = game.getBoardHeight() - 1;
				}

				if (newY111 < 0) {
					newY111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX111);
				radiusJ.add(newY111);
				radius.add(newX111 * 6 + newY111);

				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);

				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

			}
			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof SideKickP2) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();

				// up
				int newX1 = posI + 1;

				if (newX1 == game.getBoardHeight()) {
					newX1 = 0;
				}
				radiusI.add(newX1);
				radiusJ.add(posJ);
				radius.add(newX1 * 6 + posJ);

				// left
				int newY1 = posJ - 1;

				if (newY1 < 0) {
					newY1 = game.getBoardWidth() - 1;
				}

				radiusI.add(posI);
				radiusJ.add(newY1);
				radius.add(posI * 6 + newY1);

				int newY = posJ + 1;
				// right
				if (newY == game.getBoardWidth()) {
					newY = 0;
				}
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);

				// downright
				int newX1111 = posI + 1;
				int newY1111 = posJ + 1;

				if (newX1111 == game.getBoardHeight()) {
					newX1111 = 0;
				}

				if (newY1111 == game.getBoardWidth()) {
					newY1111 = 0;
				}
				radiusI.add(newX1111);
				radiusJ.add(newY1111);
				radius.add(newX1111 * 6 + newY1111);

				// downleft

				int newX11111 = posI + 1;
				int newY11111 = posJ - 1;

				if (newX11111 == game.getBoardHeight()) {
					newX11111 = 0;
				}
				if (newY11111 < 0) {
					newY11111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX11111);
				radiusJ.add(newY11111);
				radius.add(newX11111 * 6 + newY11111);

				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);

				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

			}
			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof Speedster) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				int PJ = posJ;
				int newX;
				int newY;
				// up
				newX = posI - 2 + game.getBoardHeight();

				newX %= game.getBoardHeight();
				radiusI.add(newX);
				radiusJ.add(PJ);
				radius.add(newX * 6 + PJ);

				// down
				newX = posI + 2;

				newX %= game.getBoardHeight();
				radiusI.add(newX);
				radiusJ.add(PJ);
				radius.add(newX * 6 + PJ);

				// right
				newY = posJ + 2;

				newY %= game.getBoardWidth();
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);

				// left
				newY = posJ - 2 + game.getBoardWidth();

				newY %= game.getBoardWidth();
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);

				// upright

				newX = posI - 2 + game.getBoardHeight();
				newY = posJ + 2;

				newX %= game.getBoardHeight();

				newY %= game.getBoardWidth();
				radiusI.add(newX);
				radiusJ.add(newY);
				radius.add(newX * 6 + newY);

				// upleft

				newX = posI - 2 + game.getBoardHeight();
				newY = posJ - 2 + game.getBoardWidth();

				newX %= game.getBoardHeight();

				newY %= game.getBoardWidth();

				radiusI.add(newX);
				radiusJ.add(newY);
				radius.add(newX * 6 + newY);

				// downright

				newX = posI + 2;
				newY = posJ + 2;

				newX %= game.getBoardHeight();

				newY %= game.getBoardWidth();

				radiusI.add(newX);
				radiusJ.add(newY);
				radius.add(newX * 6 + newY);

				// downleft

				newX = posI + 2;
				newY = posJ - 2 + game.getBoardWidth();

				newX %= game.getBoardHeight();

				newY %= game.getBoardWidth();

				radiusI.add(newX);
				radiusJ.add(newY);
				radius.add(newX * 6 + newY);

				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);

				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

			}
			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof Tech) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				// upright

				int newX11 = posI - 1;
				int newY11 = posJ + 1;

				if (newX11 < 0) {
					newX11 = game.getBoardHeight() - 1;
				}

				if (newY11 == game.getBoardWidth()) {
					newY11 = 0;
				}
				radiusI.add(newX11);
				radiusJ.add(newY11);
				radius.add(newX11 * 6 + newY11);

				// upleft
				int newX111 = posI - 1;
				int newY111 = posJ - 1;

				if (newX111 < 0) {
					newX111 = game.getBoardHeight() - 1;
				}

				if (newY111 < 0) {
					newY111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX111);
				radiusJ.add(newY111);
				radius.add(newX111 * 6 + newY111);

				// downright
				int newX1111 = posI + 1;
				int newY1111 = posJ + 1;

				if (newX1111 == game.getBoardHeight()) {
					newX1111 = 0;
				}

				if (newY1111 == game.getBoardWidth()) {
					newY1111 = 0;
				}
				radiusI.add(newX1111);
				radiusJ.add(newY1111);
				radius.add(newX1111 * 6 + newY1111);

				// downleft

				int newX11111 = posI + 1;
				int newY11111 = posJ - 1;

				if (newX11111 == game.getBoardHeight()) {
					newX11111 = 0;
				}
				if (newY11111 < 0) {
					newY11111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX11111);
				radiusJ.add(newY11111);
				radius.add(newX11111 * 6 + newY11111);

				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);

				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

			}

			if (game.getCellAt(aI, aJ).getPiece() != null && game.getCellAt(aI, aJ).getPiece() instanceof Ranged
					|| game.getCellAt(aI, aJ).getPiece() instanceof Armored) {

				int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				// down
				int newX = posI - 1;

				if (newX < 0) {
					newX = game.getBoardHeight() - 1;
				}
				radiusI.add(newX);
				radiusJ.add(posJ);
				radius.add(newX * 6 + posJ);
				// up
				int newX1 = posI + 1;

				if (newX1 == game.getBoardHeight()) {
					newX1 = 0;
				}
				radiusI.add(newX1);
				radiusJ.add(posJ);
				radius.add(newX1 * 6 + posJ);

				// left
				int newY1 = posJ - 1;

				if (newY1 < 0) {
					newY1 = game.getBoardWidth() - 1;
				}

				radiusI.add(posI);
				radiusJ.add(newY1);
				radius.add(posI * 6 + newY1);

				int newY = posJ + 1;
				// right
				if (newY == game.getBoardWidth()) {
					newY = 0;
				}
				radiusI.add(posI);
				radiusJ.add(newY);
				radius.add(posI * 6 + newY);

				// upright

				int newX11 = posI - 1;
				int newY11 = posJ + 1;

				if (newX11 < 0) {
					newX11 = game.getBoardHeight() - 1;
				}

				if (newY11 == game.getBoardWidth()) {
					newY11 = 0;
				}
				radiusI.add(newX11);
				radiusJ.add(newY11);
				radius.add(newX11 * 6 + newY11);

				// upleft
				int newX111 = posI - 1;
				int newY111 = posJ - 1;

				if (newX111 < 0) {
					newX111 = game.getBoardHeight() - 1;
				}

				if (newY111 < 0) {
					newY111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX111);
				radiusJ.add(newY111);
				radius.add(newX111 * 6 + newY111);

				// downright
				int newX1111 = posI + 1;
				int newY1111 = posJ + 1;

				if (newX1111 == game.getBoardHeight()) {
					newX1111 = 0;
				}

				if (newY1111 == game.getBoardWidth()) {
					newY1111 = 0;
				}
				radiusI.add(newX1111);
				radiusJ.add(newY1111);
				radius.add(newX1111 * 6 + newY1111);

				// downleft

				int newX11111 = posI + 1;
				int newY11111 = posJ - 1;

				if (newX11111 == game.getBoardHeight()) {
					newX11111 = 0;
				}
				if (newY11111 < 0) {
					newY11111 = game.getBoardWidth() - 1;
				}

				radiusI.add(newX11111);
				radiusJ.add(newY11111);
				radius.add(newX11111 * 6 + newY11111);
				posI = game.getCellAt(aI, aJ).getPiece().getPosI();
				posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();
				radiusI.add(posI);
				radiusJ.add(posJ);
				radius.add(posI * 6 + posJ);
				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}

					}
				}

				Image image1 = null;
				try {
					image1 = ImageIO.read(getClass().getResource("/images/green.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

				Image image2 = null;
				try {
					image2 = ImageIO.read(getClass().getResource("/images/red.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

				Component x = e.getComponent();

				int tempi = x.getY();
				int tempj = x.getX();

				int newtempj = 0;
				if (tempj == 0)
					newtempj = 0;
				if (tempj != 0)
					newtempj = tempj / 100;

				int newtempi = 0;
				if (tempi == 2)
					newtempi = 0;
				if (tempi == 87)
					newtempi = 1;
				if (tempi == 172)
					newtempi = 2;
				if (tempi == 257)
					newtempi = 3;
				if (tempi == 342)
					newtempi = 4;
				if (tempi == 427)
					newtempi = 5;
				if (tempi == 512)
					newtempi = 6;

				for (int i = 0; i < radius.size() - 1; i++) {
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() == game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							square.setImage(image2);

						}

					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null)
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece().getOwner() != game
								.getCellAt(aI, aJ).getPiece().getOwner()) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
						square.setImage(image1);

					}
				}

			}

			storeOrig(aI, aJ);
			if (c1 instanceof JPanel)
				return;
			Point parentLocation = c1.getParent().getLocation();
			xAdjustment = parentLocation.x - e.getX();
			yAdjustment = parentLocation.y - e.getY();

			chessPiece = (JLabel) c1;
			chessPiece.setLocation(e.getX() + xAdjustment + 25, e.getY() + yAdjustment + 150);

			add(chessPiece, JLayeredPane.DRAG_LAYER);
			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

		} else if (SwingUtilities.isRightMouseButton(e)) {
			MedicDir.clear();
			radiusI.clear();
			radiusJ.clear();
			radius.clear();
			int aJ = 0;
			int aI = 0;
			c1 = chessBoard.findComponentAt(e.getX(), e.getY());

			cordJorig = chessBoard.getComponentAt(e.getX(), e.getY()).getX();
			cordIorig = chessBoard.getComponentAt(e.getX(), e.getY()).getY();
			if (cordJorig == 0)
				aJ = 0;
			if (cordJorig != 0)
				aJ = cordJorig / 100;

			if (cordIorig == 2)
				aI = 0;
			if (cordIorig == 87)
				aI = 1;
			if (cordIorig == 172)
				aI = 2;
			if (cordIorig == 257)
				aI = 3;
			if (cordIorig == 342)
				aI = 4;
			if (cordIorig == 427)
				aI = 5;
			if (cordIorig == 512)
				aI = 6;
			if (game.getCellAt(aI, aJ).getPiece() != null) {
				if (!(game.getCellAt(aI, aJ).getPiece() instanceof ActivatablePowerHero)) {
					JOptionPane.showMessageDialog(null, "The piece you clicked has no activatable power", "No power",
							JOptionPane.ERROR_MESSAGE);

				}
				if (game.getCellAt(aI, aJ).getPiece() instanceof Medic) {
					if (game.getCurrentPlayer() != game.getCellAt(aI, aJ).getPiece().getOwner()) {
						JOptionPane.showMessageDialog(null, "Wrong turn", "Wrong turn", JOptionPane.ERROR_MESSAGE);
					} else if (((ActivatablePowerHero) game.getCellAt(aI, aJ).getPiece()).isPowerUsed() == true) {
						JOptionPane.showMessageDialog(null, "Power already used", "Already used",
								JOptionPane.ERROR_MESSAGE);
					} else if (game.getCurrentPlayer().getDeadCharacters().size() == 0) {
						JOptionPane.showMessageDialog(null, "There are no dead characters.", "No targets",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int posI = game.getCellAt(aI, aJ).getPiece().getPosI();
						int posJ = game.getCellAt(aI, aJ).getPiece().getPosJ();

						// down

						int newX = posI - 1;

						if (newX < 0) {
							newX = game.getBoardHeight() - 1;
						}
						radiusI.add(newX);
						radiusJ.add(posJ);
						radius.add(newX * 6 + posJ);
						MedicDir.add(Direction.UP);

						// up
						newX = posI + 1;

						if (newX == game.getBoardHeight()) {
							newX = 0;
						}
						radiusI.add(newX);
						radiusJ.add(posJ);
						radius.add(newX * 6 + posJ);
						MedicDir.add(Direction.DOWN);

						// left
						int newY = posJ + 1;

						if (newY == game.getBoardWidth()) {
							newY = 0;
						}
						radiusI.add(posI);
						radiusJ.add(newY);
						radius.add(posI * 6 + newY);
						MedicDir.add(Direction.RIGHT);

						newY = posJ - 1;

						if (newY < 0) {
							newY = game.getBoardWidth() - 1;
						}
						radiusI.add(posI);
						radiusJ.add(newY);
						radius.add(posI * 6 + newY);
						MedicDir.add(Direction.LEFT);

						// upright

						newX = posI - 1;
						newY = posJ + 1;

						if (newX < 0) {
							newX = game.getBoardHeight() - 1;
						}

						if (newY == game.getBoardWidth()) {
							newY = 0;
						}
						radiusI.add(newX);
						radiusJ.add(newY);
						radius.add(newX * 6 + newY);
						MedicDir.add(Direction.UPRIGHT);

						// upleft
						newX = posI - 1;
						newY = posJ - 1;

						if (newX < 0) {
							newX = game.getBoardHeight() - 1;
						}

						if (newY < 0) {
							newY = game.getBoardWidth() - 1;
						}
						radiusI.add(newX);
						radiusJ.add(newY);
						radius.add(newX * 6 + newY);
						MedicDir.add(Direction.UPLEFT);

						// downright
						newX = posI + 1;
						newY = posJ + 1;

						if (newX == game.getBoardHeight()) {
							newX = 0;
						}

						if (newY == game.getBoardWidth()) {
							newY = 0;
						}
						radiusI.add(newX);
						radiusJ.add(newY);
						radius.add(newX * 6 + newY);
						MedicDir.add(Direction.DOWNRIGHT);

						// downleft

						newX = posI + 1;
						newY = posJ - 1;

						if (newX == game.getBoardHeight()) {
							newX = 0;
						}
						if (newY < 0) {
							newY = game.getBoardWidth() - 1;
						}
						radiusI.add(newX);
						radiusJ.add(newY);
						radius.add(newX * 6 + newY);
						MedicDir.add(Direction.DOWNLEFT);

						if (game.getCellAt(aI, aJ).getPiece().getOwner() == game.getPlayer1())
							listengrave((Medic) game.getCellAt(aI, aJ).getPiece());
						else
							listengrave2((Medic) game.getCellAt(aI, aJ).getPiece());

						for (int i = 0; i < radius.size(); i++) {
							if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
								BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
								try {
									square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}
							if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() == null) {
								BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(radius.get(i));
								try {
									square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}
						}

					}
				}
				if (game.getCellAt(aI, aJ).getPiece() instanceof Tech && rangedclick == false) {
					techclickcount++;
					if (game.getCurrentPlayer() != game.getCellAt(aI, aJ).getPiece().getOwner()) {
						JOptionPane.showMessageDialog(null, "Wrong turn", "Wrong turn", JOptionPane.ERROR_MESSAGE);
					} else if (((ActivatablePowerHero) game.getCellAt(aI, aJ).getPiece()).isPowerUsed() == true) {
						JOptionPane.showMessageDialog(null, "Power already used", "Already used",
								JOptionPane.ERROR_MESSAGE);
					} else if (techclickcount == 1) {
						if (techclick == true) {
							for (int i = 0; i < techradius.size(); i++) {
								BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techradius.get(i));
								try {
									square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}
							techclick = false;
							return;
						}

						techclick = true;
						tech1 = (Tech) game.getCellAt(aI, aJ).getPiece();
						for (int i = 0; i < 7; i++) {
							for (int j = 0; j < 6; j++) {
								if (game.getCellAt(i, j).getPiece() == null) {
									techradiusI.add(i);
									techradiusJ.add(j);
									techradius.add(i * 6 + j);
								}
							}
						}
						for (int i = 0; i < techradius.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techradius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
					} else if (techclickcount == 2) {
						tech1 = (Tech) game.getCellAt(aI, aJ).getPiece();

						techclick = false;
						techclick2 = true;
						for (int i = 0; i < techradius.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techradius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						techradius.clear();
						for (int i = 0; i < 7; i++) {
							for (int j = 0; j < 6; j++) {
								if (game.getCellAt(i, j).getPiece() != null)
									{if (game.getCellAt(i, j).getPiece() instanceof ActivatablePowerHero) {
										if (game.getCellAt(i, j).getPiece().getOwner() != tech1.getOwner()
												&& ((ActivatablePowerHero) game.getCellAt(i, j).getPiece())
														.isPowerUsed() == false)
											techblue.add(i * 6 + j);
										if (game.getCellAt(i, j).getPiece().getOwner() == tech1.getOwner()
												&& ((ActivatablePowerHero) game.getCellAt(i, j).getPiece())
														.isPowerUsed() == true)
											techgreen.add(i * 6 + j);
										if (game.getCellAt(i, j).getPiece().getOwner() == tech1.getOwner()
												&& ((ActivatablePowerHero) game.getCellAt(i, j).getPiece())
														.isPowerUsed() == false)
											techred.add(i * 6 + j);
									} else if (game.getCellAt(i, j).getPiece() != null && !(game.getCellAt(i, j).getPiece() instanceof Armored))
										techred.add(i * 6 + j);
									}
								if ((game.getCellAt(i, j).getPiece()) instanceof Armored)
								{
									if ((((Armored) game.getCellAt(i, j).getPiece()).isArmorUp()==true))
									{
										if (game.getCellAt(i, j).getPiece().getOwner() != tech1.getOwner())
										{
											techblue.add(i * 6 + j);

										}
									}
									else{
										if (game.getCellAt(i, j).getPiece().getOwner() == tech1.getOwner())
										{
											techgreen.add(i * 6 + j);

										}
									}
									}
								}


							
						}
						for (int i = 0; i < techblue.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techblue.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techred.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techred.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techgreen.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techgreen.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

					} else if (techclickcount == 3) {
						for (int i = 0; i < techred.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techred.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techblue.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techblue.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < techgreen.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techgreen.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						techclickcount = 0;
						techclick = false;
						techclick2 = false;

						techclickcount = 0;
						techblue.clear();
						techred.clear();
						techgreen.clear();
					}

				}
				if (game.getCellAt(aI, aJ).getPiece() instanceof Ranged && techclick == false) {

					for (int i = 0; i < rangedbluedown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedbluedown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedbluedown.clear();

					for (int i = 0; i < rangedgreendown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreendown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreendown.clear();
					for (int i = 0; i < rangedreddown.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedreddown.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedreddown.clear();
					for (int i = 0; i < rangedblueup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueup.clear();

					for (int i = 0; i < rangedgreenup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenup.clear();
					for (int i = 0; i < rangedredup.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredup.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredup.clear();
					for (int i = 0; i < rangedblueright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueright.clear();

					for (int i = 0; i < rangedgreenright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenright.clear();
					for (int i = 0; i < rangedredright.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredright.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredright.clear();
					for (int i = 0; i < rangedblueleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedblueleft.clear();

					for (int i = 0; i < rangedgreenleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedgreenleft.clear();
					for (int i = 0; i < rangedredleft.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredleft.get(i));
						try {
							square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
					}
					rangedredleft.clear();

					Ranged1 = (Ranged) game.getCellAt(aI, aJ).getPiece();
					if (game.getCurrentPlayer() != game.getCellAt(aI, aJ).getPiece().getOwner()) {
						JOptionPane.showMessageDialog(null, "Wrong turn", "Wrong turn", JOptionPane.ERROR_MESSAGE);
					} else if (((ActivatablePowerHero) game.getCellAt(aI, aJ).getPiece()).isPowerUsed() == true) {
						JOptionPane.showMessageDialog(null, "Power already used", "Already used",
								JOptionPane.ERROR_MESSAGE);
					} else {// up aka i keeps going down until 0
						Boolean found = false;
						Boolean collide = false;
						for (int i = aI - 1; i >= 0; i--) {
							if (game.getCellAt(i, aJ).getPiece() != null) {
								if (game.getCellAt(i, aJ).getPiece().getOwner() == Ranged1.getOwner()) {
									collide = true;
									rangedredup.add(i * 6 + aJ);
									break;
								}

								else if (game.getCellAt(i, aJ).getPiece().getOwner() != Ranged1.getOwner()) {
									Rangeduptarget = game.getCellAt(i, aJ).getPiece();
									rangedblueup.add(i * 6 + aJ);
									break;
								}

							} else {
								rangedgreenup.add(i * 6 + aJ);
							}

						}
						if (rangedblueup.size() == 0 && rangedgreenup.size() > 0 && rangedredup.size() == 0) {
							rangedredup.add(rangedgreenup.get(rangedgreenup.size() - 1));
							rangedgreenup.remove(rangedgreenup.size() - 1);
						}

						for (int i = 0; i < rangedblueup.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueup.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < rangedredup.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredup.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int i = 0; i < rangedgreenup.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenup.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int i = Ranged1.getPosI() + 1; i <= 6; i++) {
							if (game.getCellAt(i, Ranged1.getPosJ()).getPiece() != null) {
								if (game.getCellAt(i, Ranged1.getPosJ()).getPiece().getOwner() == Ranged1.getOwner()) {
									collide = true;
									rangedreddown.add(i * 6 + Ranged1.getPosJ());
									break;
								}

								else if (game.getCellAt(i, Ranged1.getPosJ()).getPiece().getOwner() != Ranged1
										.getOwner()) {
									Rangeddowntarget = game.getCellAt(i, Ranged1.getPosJ()).getPiece();
									rangedbluedown.add(i * 6 + Ranged1.getPosJ());
									break;
								}

							} else {
								rangedgreendown.add(i * 6 + Ranged1.getPosJ());
							}

						}
						if (rangedbluedown.size() == 0 && rangedgreendown.size() > 0 && rangedreddown.size() == 0) {
							rangedreddown.add(rangedgreendown.get(rangedgreendown.size() - 1));
							rangedgreendown.remove(rangedgreendown.size() - 1);
						}

						for (int i = 0; i < rangedbluedown.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedbluedown.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < rangedreddown.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedreddown.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int i = 0; i < rangedgreendown.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreendown.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int j = Ranged1.getPosJ() + 1; j <= 5; j++) {
							if (game.getCellAt(Ranged1.getPosI(), j).getPiece() != null) {
								if (game.getCellAt(Ranged1.getPosI(), j).getPiece().getOwner() == Ranged1.getOwner()) {
									collide = true;
									rangedredright.add(Ranged1.getPosI() * 6 + j);
									break;
								}

								else if (game.getCellAt(Ranged1.getPosI(), j).getPiece().getOwner() != Ranged1
										.getOwner()) {
									Rangedrighttarget = game.getCellAt(Ranged1.getPosI(), j).getPiece();
									rangedblueright.add(Ranged1.getPosI() * 6 + j);
									break;
								}

							} else {
								rangedgreenright.add(Ranged1.getPosI() * 6 + j);
							}

						}
						if (rangedblueright.size() == 0 && rangedgreenright.size() > 0 && rangedredright.size() == 0) {
							rangedredright.add(rangedgreenright.get(rangedgreenright.size() - 1));
							rangedgreenright.remove(rangedgreenright.size() - 1);
						}

						for (int i = 0; i < rangedblueright.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueright.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < rangedredright.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredright.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int i = 0; i < rangedgreenright.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenright.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int j = Ranged1.getPosJ() - 1; j >= 0; j--) {
							if (game.getCellAt(Ranged1.getPosI(), j).getPiece() != null) {
								if (game.getCellAt(Ranged1.getPosI(), j).getPiece().getOwner() == Ranged1.getOwner()) {
									collide = true;
									rangedredleft.add(Ranged1.getPosI() * 6 + j);
									break;
								}

								else if (game.getCellAt(Ranged1.getPosI(), j).getPiece().getOwner() != Ranged1
										.getOwner()) {
									Rangedlefttarget = game.getCellAt(Ranged1.getPosI(), j).getPiece();
									rangedblueleft.add(Ranged1.getPosI() * 6 + j);
									break;
								}

							} else {
								rangedgreenleft.add(Ranged1.getPosI() * 6 + j);
							}

						}
						if (rangedblueleft.size() == 0 && rangedgreenleft.size() > 0 && rangedredleft.size() == 0) {
							rangedredleft.add(rangedgreenleft.get(rangedgreenleft.size() - 1));
							rangedgreenleft.remove(rangedgreenleft.size() - 1);
						}

						for (int i = 0; i < rangedblueleft.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedblueleft.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						for (int i = 0; i < rangedredleft.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedredleft.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						for (int i = 0; i < rangedgreenleft.size(); i++) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(rangedgreenleft.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (Rangedlefttarget != null)
							if (Rangeduptarget != null)
								if (Rangeddowntarget != null)
									if (Rangedrighttarget != null)
										rangedrelease = true;
						rangedclick = true;
						clickcounter++;
						rangeddrag = true;
						rangedclickcount = 1;
						int posI = Ranged1.getPosI();
						int posJ = Ranged1.getPosJ();
						// Up
						int newX = posI - 1;

						if ((newX >= 0)) {
							rangedradius.add(newX * 6 + posJ);
							rangeddir.add(Direction.UP);
						}

						// up
						int newX1 = posI + 1;

						if ((newX1 != game.getBoardHeight())) {
							rangedradius.add(newX1 * 6 + posJ);
							rangeddir.add(Direction.DOWN);

						}

						// left
						int newY1 = posJ - 1;

						if ((newY1 >= 0)) {
							rangedradius.add(posI * 6 + newY1);
							rangeddir.add(Direction.LEFT);

						}

						int newY = posJ + 1;
						// right
						if (newY != game.getBoardWidth()) {
							rangedradius.add(posI * 6 + newY);
							rangeddir.add(Direction.RIGHT);

						}
					}
					toggle = true;
				}
				if (game.getCellAt(aI, aJ).getPiece() instanceof Super) {

					if (game.getCurrentPlayer() != game.getCellAt(aI, aJ).getPiece().getOwner()) {
						JOptionPane.showMessageDialog(null, "Wrong turn", "Wrong turn", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (((ActivatablePowerHero) game.getCellAt(aI, aJ).getPiece()).isPowerUsed() == true) {
						JOptionPane.showMessageDialog(null, "Power already used", "Already used",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					Super1 = (Super) game.getCellAt(aI, aJ).getPiece();

					int posI = Super1.getPosI();
					int posJ = Super1.getPosJ();
					// Up
					int newX = posI - 1;

					if ((newX >= 0)) {
						superI.add(newX);
						superJ.add(posJ);
						superradius.add(newX * 6 + posJ);
						superdir.add(Direction.UP);
					}
					newX = newX - 1;
					if ((newX >= 0)) {
						superI.add(newX);
						superJ.add(posJ);
						superradius.add(newX * 6 + posJ);
						superdir.add(Direction.UP);
					}
					// up
					int newX1 = posI + 1;

					if ((newX1 != game.getBoardHeight())) {
						superI.add(newX1);
						superJ.add(posJ);
						superradius.add(newX1 * 6 + posJ);
						superdir.add(Direction.DOWN);

					}
					newX1 = newX1 + 1;

					if ((newX1 != game.getBoardHeight())) {
						superI.add(newX1);
						superJ.add(posJ);
						superradius.add(newX1 * 6 + posJ);
						superdir.add(Direction.DOWN);

					}

					// left
					int newY1 = posJ - 1;

					if ((newY1 >= 0)) {
						superI.add(posI);
						superJ.add(newY1);
						superradius.add(posI * 6 + newY1);
						superdir.add(Direction.LEFT);

					}

					newY1 = newY1 - 1;
					if ((newY1 >= 0)) {
						superI.add(posI);
						superJ.add(newY1);
						superradius.add(posI * 6 + newY1);
						superdir.add(Direction.LEFT);

					}

					int newY = posJ + 1;
					// right
					if (newY != game.getBoardWidth() && newY < game.getBoardWidth()) {
						superI.add(posI);
						superJ.add(newY);
						superradius.add(posI * 6 + newY);
						superdir.add(Direction.RIGHT);

					}
					newY = newY + 1;

					if (newY != game.getBoardWidth() && newY < game.getBoardWidth()) {
						superI.add(posI);
						superJ.add(newY);
						superradius.add(posI * 6 + newY);
						superdir.add(Direction.RIGHT);

					}

					for (int i = 0; i < superradius.size(); i++) {
						if (game.getCellAt(superI.get(i), superJ.get(i)).getPiece() != null) {
							if (game.getCellAt(superI.get(i), superJ.get(i)).getPiece().getOwner() != Super1
									.getOwner()) {
								BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(superradius.get(i));
								try {
									square.setImage(ImageIO.read(getClass().getResource("/images/blue.png")));
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}
							}
							if (game.getCellAt(superI.get(i), superJ.get(i)).getPiece().getOwner() == Super1
									.getOwner()) {
								BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(superradius.get(i));
								try {
									square.setImage(ImageIO.read(getClass().getResource("/images/red.png")));
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}
							}

						}
						if (game.getCellAt(superI.get(i), superJ.get(i)).getPiece() == null) {
							BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(superradius.get(i));
							try {
								square.setImage(ImageIO.read(getClass().getResource("/images/green.png")));
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}
						}
						superclick = true;
					}

				}

			}
		}

	}

	/*
	 ** Move the chess piece around
	 */

	public void listenall() {

	}

	public void gamewon() {
		chessBoard.removeMouseListener(this);
		chessBoard.removeMouseMotionListener(this);
	}

	public void delisten() {
		for (int i = 0; i <= 41; i++) {
			chessBoard.getComponent(i).removeMouseListener(x1);

		}
		radiusI.clear();
		radiusJ.clear();
		radius.clear();
		MedicDir.clear();
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (gameended == true)
			return;

		if (superdrag == true) {
			superdrag = false;
			return;
		}
		if (rangeddrag == true) {
			rangeddrag = false;
			return;
		}
		if (techdrag2 == true) {
			techdrag2 = false;
			return;
		}
		if (SwingUtilities.isLeftMouseButton(me) && techdrag == false) {
			if (chessPiece == null)
				return;
			if (empty == true) {

				return;
			}
			// The drag location should be within the bounds of the chess board

			int x1 = me.getX() + xAdjustment;
			int xMax = chessBoard.getWidth() - chessPiece.getWidth();
			x1 = Math.min(x1, xMax);
			x = Math.max(x1, 0);

			int y = me.getY() + yAdjustment;
			int yMax = chessBoard.getHeight() - chessPiece.getHeight();
			y = Math.min(y, yMax);
			y = Math.max(y, 0);

			chessPiece.setLocation(x + 25, y + 150);

		}
		if (clicked == null)
			return;
		if (techdrag == true) {
			// int x = me.getX() + xAdjustment;
			// int xMax = chessBoard.getWidth() - chessPiece.getWidth();
			// x = Math.min(x, xMax);
			// x = Math.max(x, 0);

			// int y = me.getY() + yAdjustment;
			// int yMax = chessBoard.getHeight() - chessPiece.getHeight();
			// y = Math.min(y, yMax);
			// y = Math.max(y, 0);

			clicked.setLocation(me.getX() - 20, me.getY() + 110);
			add(clicked, JLayeredPane.DRAG_LAYER);

			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

			return;

		}
		if (SwingUtilities.isLeftMouseButton(me)) {
			if (chessPiece == null)
				return;
			if (empty == true) {

				return;
			}
			// The drag location should be within the bounds of the chess board

			int x = me.getX() + xAdjustment;
			int xMax = chessBoard.getWidth() - chessPiece.getWidth();
			x = Math.min(x, xMax);
			x = Math.max(x, 0);

			int y = me.getY() + yAdjustment;
			int yMax = chessBoard.getHeight() - chessPiece.getHeight();
			y = Math.min(y, yMax);
			y = Math.max(y, 0);

			chessPiece.setLocation(x + 25, y + 150);

			add(chessPiece, JLayeredPane.DRAG_LAYER);
			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

		}

	}

	int aJ1 = 0;
	int aI1 = 0;
	int clickx;
	int clicky;

	@Override
	public void mouseReleased(MouseEvent e) {
		if (superrelease == true) {
			superrelease = false;
			return;
		}
		if (rangedrelease == true) {
			rangedrelease = false;
			return;
		}
		if (techrelease2 == true) {
			for (int i = 0; i < techred.size(); i++) {
				BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techred.get(i));
				try {
					square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

			}
			for (int i = 0; i < techblue.size(); i++) {
				BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techblue.get(i));
				try {
					square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

			}
			for (int i = 0; i < techgreen.size(); i++) {
				BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techgreen.get(i));
				try {
					square.setImage(ImageIO.read(getClass().getResource("/images/brick.png")));
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

			}
			techclickcount = 1;
			techblue.clear();
			techred.clear();
			techgreen.clear();
			techrelease2 = false;
			return;
		}
		if ((SwingUtilities.isLeftMouseButton(e))) {
			if (techrelease == true) {
				clickx = e.getX();
				clicky = e.getY();

				c1 = chessBoard.findComponentAt(clickx, clicky);

				if (c1 == null) {
					JOptionPane.showMessageDialog(null, "invalid target", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					techrelease = false;
					techdrag = false;
					techclick = false;
				} else {
					cordJorig = c1.getX();
					cordIorig = c1.getY();

					if (cordJorig == 0)
						aJ1 = 0;
					if (cordJorig != 0)
						aJ1 = cordJorig / 100;

					if (cordIorig == 2)
						aI1 = 0;
					if (cordIorig == 87)
						aI1 = 1;
					if (cordIorig == 172)
						aI1 = 2;
					if (cordIorig == 257)
						aI1 = 3;
					if (cordIorig == 342)
						aI1 = 4;
					if (cordIorig == 427)
						aI1 = 5;
					if (cordIorig == 512)
						aI1 = 6;

					if (c1 instanceof JLabel) {
						aI1 = -1;
						aJ1 = -1;
					}
					Boolean found = false;

					for (int i = 0; i < techradius.size(); i++) {
						if (aI1 * 6 + aJ1 == techradius.get(i)) {
							found = true;

							Component c1 = chessBoard.getComponent(techradius.get(i));
							Container parent1 = (Container) c1;

							JLabel piece = null;
							try {
								piece = getres(techtarget);
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}
							parent1.add(piece);
							chessBoard.repaint();
						}
					}

					if (found == false || c1 instanceof JLabel) {

						JOptionPane.showMessageDialog(null, "Can't teleport here", "Wrong location " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						Component c1 = chessBoard.getComponent(techtarget.getPosI() * 6 + techtarget.getPosJ());
						Container parent1 = (Container) c1;
						techrelease = false;
						techdrag = false;
						techclick = false;

						JLabel piece = null;
						try {
							piece = getres(techtarget);
						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
						parent1.add(piece);
						chessBoard.repaint();

					} else {
						newPos.x = aI1;
						newPos.y = aJ1;

						try {
							if (found != false) {
								tech1.usePower(null, techtarget, newPos);
								techclick = false;
								techclick2 = false;
							}
						} catch (InvalidPowerUseException e1) {
							// TODO Auto-generated catch block

						} catch (WrongTurnException e1) {
							// TODO Auto-generated catch block

						}
					}
					techrelease = false;
					techdrag = false;
					techclick = false;
					setCursor(null);
					if (clicked != null)
						clicked.setVisible(false);
					Image image1 = null;
					try {
						image1 = ImageIO.read(getClass().getResource("/images/brick.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block

					}

					for (int i = 0; i < techradius.size(); i++) {
						BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(techradius.get(i));
						square.setImage(image1);

					}

					techradius.clear();
					techradiusI.clear();
					techradiusJ.clear();
					glow();

					return;
				}
			}

			int index = 0;
			Piece curr = game.getCellAt(origI, origJ).getPiece();
			chessBoard.getComponentAt(e.getX(), e.getY());
			if (c1 == chessBoard.getComponentAt(e.getX(), e.getY()))
				return;
			for (int i = 0; i < radius.size(); i++) {
				clean.add(radius.get(i));

			}
			if (empty == true) {

				empty = false;
				return;
			}
			if (chessPiece == null)
				return;
			if (curr instanceof Super || curr instanceof Medic) {
				for (int i = 0; i < radius.size(); i++) {
					if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
						index = radius.get(i);
					}

				}
				Boolean has = false;
				Boolean found = false;
				// index is pos on board
				for (int i = 0; i < radius.size(); i++) {
					if (radius.get(i) == index) {
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
							has = true;

						}
						if (i == 0) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UP) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);
										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 1) {

							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWN) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 2) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.LEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 3) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.RIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 4) {
							found = true;
							Component c = chessBoard.getComponentAt(e.getX(), e.getY());

							Container parent = (Container) c;
							parent.add(chessPiece);

						}
						radius.clear();
						radiusI.clear();
						radiusJ.clear();

					}

				}
				if (found == false && gameended == false) {
					Component c = chessBoard.getComponent(radius.get(radius.size()));

					JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					Container parent = (Container) c;
					parent.add(chessPiece);
				}
			}
			if (curr instanceof Tech) {
				for (int i = 0; i < radius.size(); i++) {
					if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
						index = radius.get(i);
					}

				}
				Boolean has = false;
				Boolean found = false;
				// index is pos on board
				for (int i = 0; i < radius.size(); i++) {
					if (radius.get(i) == index) {
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
							has = true;

						}
						if (i == 0) {
							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 1) {

							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 2) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 3) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 4) {
							found = true;
							Component c = chessBoard.getComponentAt(e.getX(), e.getY());

							Container parent = (Container) c;
							parent.add(chessPiece);

						}
						radius.clear();
						radiusI.clear();
						radiusJ.clear();

					}

				}
				if (found == false) {
					Component c = chessBoard.getComponent(radius.get(radius.size() - 1));

					JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					Container parent = (Container) c;
					parent.add(chessPiece);
				}
			}

			if (curr instanceof Armored || curr instanceof Ranged) {
				for (int i = 0; i < radius.size(); i++) {
					if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
						index = radius.get(i);
					}

				}
				Boolean has = false;
				Boolean found = false;
				// index is pos on board
				for (int i = 0; i < radius.size(); i++) {
					if (radius.get(i) == index) {
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
							has = true;

						}
						if (i == 0) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UP) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 1) {

							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWN) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 2) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.LEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 3) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.RIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 4) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 5) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 6) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 7) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 8) {
							found = true;
							Component c = chessBoard.getComponentAt(e.getX(), e.getY());

							Container parent = (Container) c;
							parent.add(chessPiece);

						}
						radius.clear();
						radiusI.clear();
						radiusJ.clear();

					}

				}
				if (found == false) {
					Component c = chessBoard.getComponent(radius.get(radius.size() - 1));

					JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					Container parent = (Container) c;
					parent.add(chessPiece);
				}
			}
			if (curr instanceof Speedster) {
				for (int i = 0; i < radius.size(); i++) {
					if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
						index = radius.get(i);
					}

				}
				Boolean has = false;
				Boolean found = false;
				// index is pos on board
				for (int i = 0; i < radius.size(); i++) {
					if (radius.get(i) == index) {
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
							has = true;

						}
						if (i == 0) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UP) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 1) {

							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWN) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 2) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.RIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 3) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.LEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 4) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 5) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 6) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 7) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 8) {
							found = true;
							Component c = chessBoard.getComponentAt(e.getX(), e.getY());

							Container parent = (Container) c;
							parent.add(chessPiece);

						}
						radius.clear();
						radiusI.clear();
						radiusJ.clear();

					}

				}
				if (found == false) {
					Component c = chessBoard.getComponent(radius.get(radius.size() - 1));

					JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					Container parent = (Container) c;
					parent.add(chessPiece);
				}
			}
			{
				if (curr instanceof SideKickP1) {
					for (int i = 0; i < radius.size(); i++) {
						if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
							index = radius.get(i);
						}

					}
					Boolean has = false;
					Boolean found = false;
					// index is pos on board
					for (int i = 0; i < radius.size(); i++) {
						if (radius.get(i) == index) {
							if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
								has = true;

							}
							if (i == 0) {
								found = true;

								try {
									if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UP) == true) {

										Component c = chessBoard.getComponentAt(e.getX(), e.getY());

										if (has == true && zombie == true) {
											flag = true;
											zombie = false;

										} else if (has == true && zombie == false) {

											Container parent = (Container) c;
											parent.removeAll();
											parent.add(chessPiece);

											parent.repaint();
										} else {
											Container parent = (Container) c;
											parent.add(chessPiece);

										}
									} else {
										if (zombie == true) {
											flag = true;
											zombie = false;
										}
										String urp = null;
										JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

										int pos = 0;
										int pos1 = 0;
										if (origI == 0)
											pos = 0;
										if (origI != 0)
											pos = origI * 6;

										pos1 = origJ + 1;

										JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
										panel.add(piece);

									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}
							if (i == 1) {

								found = true;

								try {
									if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.LEFT) == true) {

										Component c = chessBoard.getComponentAt(e.getX(), e.getY());

										if (has == true && zombie == true) {
											flag = true;
											zombie = false;

										} else if (has == true && zombie == false) {

											Container parent = (Container) c;
											parent.removeAll();
											parent.add(chessPiece);

											parent.repaint();
										} else {
											Container parent = (Container) c;
											parent.add(chessPiece);

										}
									} else {
										if (zombie == true) {
											flag = true;
											zombie = false;
										}
										String urp = null;
										JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

										int pos = 0;
										int pos1 = 0;
										if (origI == 0)
											pos = 0;
										if (origI != 0)
											pos = origI * 6;

										pos1 = origJ + 1;

										JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
										panel.add(piece);

									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}
							if (i == 2) {
								found = true;
								try {
									if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.RIGHT) == true) {

										Component c = chessBoard.getComponentAt(e.getX(), e.getY());

										if (has == true && zombie == true) {
											flag = true;
											zombie = false;

										} else if (has == true && zombie == false) {

											Container parent = (Container) c;
											parent.removeAll();
											parent.add(chessPiece);

											parent.repaint();
										} else {
											Container parent = (Container) c;
											parent.add(chessPiece);

										}
									} else {
										if (zombie == true) {
											flag = true;
											zombie = false;
										}
										String urp = null;
										JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

										int pos = 0;
										int pos1 = 0;
										if (origI == 0)
											pos = 0;
										if (origI != 0)
											pos = origI * 6;

										pos1 = origJ + 1;

										JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
										panel.add(piece);

									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}

							if (i == 3) {
								found = true;
								try {
									if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPRIGHT) == true) {

										Component c = chessBoard.getComponentAt(e.getX(), e.getY());

										if (has == true && zombie == true) {
											flag = true;
											zombie = false;

										} else if (has == true && zombie == false) {

											Container parent = (Container) c;
											parent.removeAll();
											parent.add(chessPiece);

											parent.repaint();
										} else {
											Container parent = (Container) c;
											parent.add(chessPiece);

										}
									} else {
										if (zombie == true) {
											flag = true;
											zombie = false;
										}
										String urp = null;
										JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

										int pos = 0;
										int pos1 = 0;
										if (origI == 0)
											pos = 0;
										if (origI != 0)
											pos = origI * 6;

										pos1 = origJ + 1;

										JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
										panel.add(piece);

									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}

							}

							if (i == 4) {
								found = true;
								try {
									if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.UPLEFT) == true) {

										Component c = chessBoard.getComponentAt(e.getX(), e.getY());

										if (has == true && zombie == true) {
											flag = true;
											zombie = false;

										} else if (has == true && zombie == false) {

											Container parent = (Container) c;
											parent.removeAll();
											parent.add(chessPiece);

											parent.repaint();
										} else {
											Container parent = (Container) c;
											parent.add(chessPiece);

										}
									} else {
										if (zombie == true) {
											flag = true;
											zombie = false;
										}
										JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

										int pos = 0;
										int pos1 = 0;
										if (origI == 0)
											pos = 0;
										if (origI != 0)
											pos = origI * 6;

										pos1 = origJ + 1;

										JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
										panel.add(piece);

									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block

								}
							}
							if (i == 5) {
								found = true;
								Component c = chessBoard.getComponentAt(e.getX(), e.getY());

								Container parent = (Container) c;
								parent.add(chessPiece);

							}
							radius.clear();
							radiusI.clear();
							radiusJ.clear();

						}

					}
					if (found == false) {
						Component c = chessBoard.getComponent(radius.get(radius.size() - 1));

						JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
								JOptionPane.INFORMATION_MESSAGE);
						Container parent = (Container) c;
						parent.add(chessPiece);
					}
				}
			}
			// put here
			if (curr instanceof SideKickP2) {
				for (int i = 0; i < radius.size(); i++) {
					if (chessBoard.getComponent(radius.get(i)) == chessBoard.getComponentAt(e.getX(), e.getY())) {
						index = radius.get(i);
					}

				}
				Boolean has = false;
				Boolean found = false;
				// index is pos on board
				for (int i = 0; i < radius.size(); i++) {
					if (radius.get(i) == index) {
						if (game.getCellAt(radiusI.get(i), radiusJ.get(i)).getPiece() != null) {
							has = true;

						}
						if (i == 0) {
							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWN) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 1) {

							found = true;

							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.LEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}
						if (i == 2) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.RIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 3) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNRIGHT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									String urp = null;
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}

						}

						if (i == 4) {
							found = true;
							try {
								if (storeNew(radiusI.get(i), radiusJ.get(i), Direction.DOWNLEFT) == true) {

									Component c = chessBoard.getComponentAt(e.getX(), e.getY());

									if (has == true && zombie == true) {
										flag = true;
										zombie = false;

									} else if (has == true && zombie == false) {

										Container parent = (Container) c;
										parent.removeAll();
										parent.add(chessPiece);

										parent.repaint();
									} else {
										Container parent = (Container) c;
										parent.add(chessPiece);

									}
								} else {
									if (zombie == true) {
										flag = true;
										zombie = false;
									}
									JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());

									int pos = 0;
									int pos1 = 0;
									if (origI == 0)
										pos = 0;
									if (origI != 0)
										pos = origI * 6;

									pos1 = origJ + 1;

									JPanel panel = (JPanel) chessBoard.getComponent((pos + pos1) - 1);
									panel.add(piece);

								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block

							}
						}
						if (i == 5) {
							found = true;
							Component c = chessBoard.getComponentAt(e.getX(), e.getY());

							Container parent = (Container) c;
							parent.add(chessPiece);

						}
						radius.clear();
						radiusI.clear();
						radiusJ.clear();

					}

				}
				if (found == false) {
					Component c = chessBoard.getComponent(radius.get(radius.size() - 1));

					JOptionPane.showMessageDialog(null, "not allowed", "InfoBox: " + "error",
							JOptionPane.INFORMATION_MESSAGE);
					Container parent = (Container) c;
					parent.add(chessPiece);
				}
			}

			// TERCH

			Image image1 = null;
			try {
				image1 = ImageIO.read(getClass().getResource("/images/brick.png"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
			}
			try {
				image1 = ImageIO.read(getClass().getResource("/images/brick.png"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
			}

			for (int i = 0; i < clean.size(); i++) {
				BackgroundPanel square = (BackgroundPanel) chessBoard.getComponent(clean.get(i));
				square.setImage(image1);

			}
			radius.clear();
			radiusI.clear();
			radiusJ.clear();

			BackgroundPanel square = (BackgroundPanel) chessBoard.getComponentAt(e.getX(), e.getY());
			if (square != null)
				square.setImage(image1);

			setCursor(null);
			delisten();
			if (chessPiece == null)
				return;

			// Make sure the chess piece is no longer painted on the layered pane

			chessPiece.setVisible(false);
			remove(chessPiece);
			chessPiece.setVisible(true);

			// The drop location should be within the bounds of the chess board

			int xMax = chessBoard.getWidth() - chessPiece.getWidth();
			int x = Math.min(e.getX(), xMax);
			x = Math.max(x, 0);

			int yMax = chessBoard.getHeight() - chessPiece.getHeight();
			int y = Math.min(e.getY(), yMax);
			y = Math.max(y, 0);
			int cordJ = chessBoard.getComponentAt(x, y).getX();
			int cordI = chessBoard.getComponentAt(x, y).getY();
			int aI = 0;
			int aJ = 0;
			if (cordJ == 0)
				aJ = 0;
			if (cordJ != 0)
				aJ = cordJ / 100;

			if (cordI == 2)
				aI = 0;
			if (cordI == 87)
				aI = 1;
			if (cordI == 172)
				aI = 2;
			if (cordI == 257)
				aI = 3;
			if (cordI == 342)
				aI = 4;
			if (cordI == 427)
				aI = 5;
			if (cordI == 512)
				aI = 6;
			boolean has1 = false;
			if (game.getCellAt(aI, aJ).getPiece() != null) {
				has1 = true;

			}

			/*
			 ** Add the selected chess piece to the dragging layer so it can be moved
			 */
			 //

			
			
			
			if (flag == true) {
				try {
					fix();
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}
				flag = false;

			}
			glow();

		}
		if (SwingUtilities.isRightMouseButton(e)) {
			if (empty == true)
				return;

		}
		chessBoard.repaint();
	}

	public void fix() throws IOException {
		int pos = 0;
		int pos1 = 0;
		if (origI == 0)
			pos = 0;
		if (origI != 0)
			pos = origI * 6;
		pos1 = origJ + 1;
		Component c = chessBoard.getComponent((pos + pos1) - 1);
		Container parent = (Container) c;

		// new
		int pos11 = 0;
		int pos111 = 0;
		if (newI == 0)
			pos111 = 0;
		if (newI != 0)
			pos111 = newI * 6;

		pos11 = newJ + 1;

		Component c1 = chessBoard.getComponent((pos111 + pos11) - 1);
		Container parent1 = (Container) c1;
		parent1.removeAll();

		//////////////////////

		String urp = null;
		origI = newI;
		origJ = newJ;
		JLabel piece = getres(game.getCellAt(origI, origJ).getPiece());
		parent1.add(piece);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public static void storeG(Game g) {
		game = g;

	}

	private static void createAndShowUI(Game g) throws IOException {
		ini();
		JFrame frame = new JFrame("Superhero Chess");
		frame.setUndecorated(true);
		// frame.setForeground(Color.BLACK);
		frame.setBackground(Color.decode("#282828"));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.add(new Board(g));
		storeG(g);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
   
	public static void main(String[] args) {
		p1 = JOptionPane.showInputDialog(null, "Player 1 Name:", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		p2 = JOptionPane.showInputDialog(null, "Player 2 Name:", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		// Dimension text = new Dimension(1002, 100);
		// player1f.setPreferredSize(text);

		player1f = new JLabel(p1);
		player2f = new JLabel(p2);
		player1f.setFont(new Font("Arial", Font.PLAIN, 16));
		player2f.setFont(new Font("Arial", Font.PLAIN, 16));
		player1f.setForeground(Color.WHITE);
		player2f.setForeground(Color.WHITE);

		//player2f.setBounds(250, 0, 500, 50);
		//player1f.setBounds(250, 825, 500, 50);
		// player1f.setPreferredSize(text);
		// player1f.setSize(text); //this line caused it
		// player1f.setSize(2000, 200);

		Player player1 = new Player(p1);
		Player player2 = new Player(p2);
		Game x = new Game(player1, player2);
		player1f.repaint();
		// player2f is on the top and 1f is the bottm the bottom is now gone
		storeG(x);
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					//
					createAndShowUI(x);
					JOptionPane.showMessageDialog(null,"Drag a piece to move.\n\nRight click to use power.\n\nMultiple right clicks cycle different powers (Teleport/Hack).\n\nIf a piece's Armor/Power is used, the piece will appear in grayscale.\n\nCurrent player pieces glow.\n\nTo revive a dead piece, drag the piece from the graveyard\nafter activating the Medic's power.\n " , "Tutorial", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		});
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}