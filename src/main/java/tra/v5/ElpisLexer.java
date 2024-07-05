/* The following code was generated by JFlex 1.7.0 */

package tra.v5;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import tra.models.*;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Elpis.flex</tt>
 */
public class ElpisLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\16\0\4\0\1\16\1\0"+
    "\1\20\1\0\1\0\3\0\1\15\1\15\1\0\1\13\1\15\1\6"+
    "\1\11\1\0\1\4\3\5\4\5\2\5\1\15\1\15\1\0\1\0"+
    "\1\0\1\0\1\17\4\10\1\22\1\10\6\0\1\23\2\0\1\24"+
    "\3\0\1\25\3\0\1\7\1\26\1\0\1\14\1\21\1\14\1\0"+
    "\1\0\1\0\1\33\3\10\1\12\1\32\5\0\1\34\5\0\1\30"+
    "\1\35\1\27\1\31\2\0\1\7\2\0\1\14\1\0\1\14\1\0"+
    "\41\0\2\0\4\0\4\0\1\0\2\0\1\0\7\0\1\0\4\0"+
    "\1\0\5\0\27\0\1\0\37\0\1\0\u01ca\0\4\0\14\0\16\0"+
    "\5\0\7\0\1\0\1\0\1\0\21\0\160\0\5\0\1\0\2\0"+
    "\2\0\4\0\1\0\1\0\6\0\1\0\1\0\3\0\1\0\1\0"+
    "\1\0\24\0\1\0\123\0\1\0\213\0\1\0\5\0\2\0\246\0"+
    "\1\0\46\0\2\0\1\0\6\0\51\0\6\0\1\0\1\0\55\0"+
    "\1\0\1\0\1\0\2\0\1\0\2\0\1\0\1\0\10\0\33\0"+
    "\4\0\4\0\15\0\6\0\5\0\1\0\4\0\13\0\1\0\1\0"+
    "\3\0\53\0\37\0\4\0\2\0\1\0\143\0\1\0\1\0\10\0"+
    "\1\0\6\0\2\0\2\0\1\0\4\0\2\0\12\0\3\0\2\0"+
    "\1\0\17\0\1\0\1\0\1\0\36\0\33\0\2\0\131\0\13\0"+
    "\1\0\16\0\12\0\41\0\11\0\2\0\4\0\1\0\2\0\1\0"+
    "\30\0\4\0\1\0\11\0\1\0\3\0\1\0\5\0\22\0\31\0"+
    "\3\0\4\0\13\0\65\0\25\0\1\0\22\0\13\0\61\0\66\0"+
    "\3\0\1\0\22\0\1\0\7\0\12\0\2\0\2\0\12\0\1\0"+
    "\20\0\3\0\1\0\10\0\2\0\2\0\2\0\26\0\1\0\7\0"+
    "\1\0\1\0\3\0\4\0\2\0\1\0\1\0\7\0\2\0\2\0"+
    "\2\0\3\0\1\0\10\0\1\0\4\0\2\0\1\0\3\0\2\0"+
    "\2\0\12\0\4\0\7\0\2\0\1\0\1\0\2\0\3\0\1\0"+
    "\6\0\4\0\2\0\2\0\26\0\1\0\7\0\1\0\2\0\1\0"+
    "\2\0\1\0\2\0\2\0\1\0\1\0\5\0\4\0\2\0\2\0"+
    "\3\0\3\0\1\0\7\0\4\0\1\0\1\0\7\0\14\0\3\0"+
    "\1\0\13\0\3\0\1\0\11\0\1\0\3\0\1\0\26\0\1\0"+
    "\7\0\1\0\2\0\1\0\5\0\2\0\1\0\1\0\10\0\1\0"+
    "\3\0\1\0\3\0\2\0\1\0\17\0\2\0\2\0\2\0\12\0"+
    "\1\0\1\0\7\0\1\0\6\0\1\0\3\0\1\0\10\0\2\0"+
    "\2\0\2\0\26\0\1\0\7\0\1\0\2\0\1\0\5\0\2\0"+
    "\1\0\1\0\7\0\2\0\2\0\2\0\3\0\7\0\3\0\4\0"+
    "\2\0\1\0\3\0\2\0\2\0\12\0\1\0\1\0\20\0\1\0"+
    "\1\0\1\0\6\0\3\0\3\0\1\0\4\0\3\0\2\0\1\0"+
    "\1\0\1\0\2\0\3\0\2\0\3\0\3\0\3\0\14\0\4\0"+
    "\5\0\3\0\3\0\1\0\4\0\2\0\1\0\6\0\1\0\16\0"+
    "\12\0\11\0\1\0\6\0\5\0\10\0\1\0\3\0\1\0\27\0"+
    "\1\0\20\0\3\0\1\0\7\0\1\0\3\0\1\0\4\0\7\0"+
    "\2\0\1\0\3\0\5\0\2\0\2\0\2\0\12\0\20\0\1\0"+
    "\3\0\1\0\10\0\1\0\3\0\1\0\27\0\1\0\12\0\1\0"+
    "\5\0\2\0\1\0\1\0\7\0\1\0\3\0\1\0\4\0\7\0"+
    "\2\0\7\0\1\0\1\0\2\0\2\0\2\0\12\0\1\0\2\0"+
    "\15\0\4\0\11\0\1\0\3\0\1\0\51\0\2\0\1\0\7\0"+
    "\1\0\3\0\1\0\4\0\1\0\5\0\3\0\1\0\7\0\3\0"+
    "\2\0\2\0\12\0\12\0\6\0\1\0\3\0\1\0\22\0\3\0"+
    "\30\0\1\0\11\0\1\0\1\0\2\0\7\0\3\0\1\0\4\0"+
    "\6\0\1\0\1\0\1\0\10\0\6\0\12\0\2\0\2\0\15\0"+
    "\60\0\1\0\2\0\7\0\4\0\10\0\10\0\1\0\12\0\47\0"+
    "\2\0\1\0\1\0\1\0\5\0\1\0\30\0\1\0\1\0\1\0"+
    "\12\0\1\0\2\0\11\0\1\0\2\0\5\0\1\0\1\0\1\0"+
    "\6\0\2\0\12\0\2\0\4\0\40\0\1\0\27\0\2\0\6\0"+
    "\12\0\13\0\1\0\1\0\1\0\1\0\1\0\4\0\2\0\10\0"+
    "\1\0\44\0\4\0\24\0\1\0\2\0\5\0\13\0\1\0\44\0"+
    "\11\0\1\0\71\0\53\0\24\0\1\0\12\0\6\0\6\0\4\0"+
    "\4\0\3\0\1\0\3\0\2\0\7\0\3\0\4\0\15\0\14\0"+
    "\1\0\17\0\2\0\46\0\1\0\1\0\5\0\1\0\2\0\53\0"+
    "\1\0\u014d\0\1\0\4\0\2\0\7\0\1\0\1\0\1\0\4\0"+
    "\2\0\51\0\1\0\4\0\2\0\41\0\1\0\4\0\2\0\7\0"+
    "\1\0\1\0\1\0\4\0\2\0\17\0\1\0\71\0\1\0\4\0"+
    "\2\0\103\0\2\0\3\0\40\0\20\0\20\0\126\0\2\0\6\0"+
    "\3\0\u026c\0\2\0\21\0\1\0\32\0\5\0\113\0\3\0\13\0"+
    "\7\0\15\0\1\0\4\0\3\0\13\0\22\0\3\0\13\0\22\0"+
    "\2\0\14\0\15\0\1\0\3\0\1\0\2\0\14\0\64\0\40\0"+
    "\3\0\1\0\3\0\2\0\1\0\2\0\12\0\41\0\4\0\1\0"+
    "\12\0\6\0\131\0\7\0\5\0\2\0\42\0\1\0\1\0\5\0"+
    "\106\0\12\0\37\0\1\0\14\0\4\0\14\0\12\0\12\0\36\0"+
    "\2\0\5\0\13\0\54\0\4\0\32\0\6\0\12\0\46\0\27\0"+
    "\5\0\4\0\65\0\12\0\1\0\35\0\2\0\13\0\6\0\12\0"+
    "\15\0\1\0\10\0\16\0\1\0\2\0\77\0\5\0\57\0\21\0"+
    "\7\0\4\0\12\0\21\0\11\0\14\0\3\0\36\0\15\0\2\0"+
    "\12\0\54\0\16\0\14\0\44\0\24\0\10\0\12\0\3\0\3\0"+
    "\12\0\44\0\2\0\11\0\7\0\53\0\2\0\3\0\20\0\3\0"+
    "\1\0\25\0\4\0\1\0\6\0\1\0\2\0\3\0\1\0\5\0"+
    "\300\0\72\0\1\0\5\0\u0116\0\2\0\6\0\2\0\46\0\2\0"+
    "\6\0\2\0\10\0\1\0\1\0\1\0\1\0\1\0\1\0\1\0"+
    "\37\0\2\0\65\0\1\0\7\0\1\0\1\0\3\0\3\0\1\0"+
    "\7\0\3\0\4\0\2\0\6\0\4\0\15\0\5\0\3\0\1\0"+
    "\7\0\16\0\5\0\32\0\5\0\20\0\2\0\23\0\1\0\13\0"+
    "\5\0\1\0\12\0\1\0\1\0\15\0\1\0\20\0\15\0\3\0"+
    "\40\0\20\0\15\0\4\0\1\0\3\0\14\0\21\0\1\0\4\0"+
    "\1\0\2\0\12\0\1\0\1\0\3\0\5\0\6\0\1\0\1\0"+
    "\1\0\1\0\1\0\1\0\4\0\1\0\13\0\2\0\4\0\5\0"+
    "\5\0\4\0\1\0\21\0\51\0\u0a77\0\57\0\1\0\57\0\1\0"+
    "\205\0\6\0\4\0\3\0\2\0\14\0\46\0\1\0\1\0\5\0"+
    "\1\0\2\0\70\0\7\0\1\0\17\0\1\0\27\0\11\0\7\0"+
    "\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0"+
    "\1\0\7\0\1\0\7\0\1\0\40\0\57\0\1\0\u01d5\0\3\0"+
    "\31\0\11\0\6\0\1\0\5\0\2\0\5\0\4\0\126\0\2\0"+
    "\2\0\2\0\3\0\1\0\132\0\1\0\4\0\5\0\53\0\1\0"+
    "\136\0\21\0\40\0\60\0\20\0\u0200\0\u19c0\0\100\0\u51fd\0\3\0"+
    "\u048d\0\103\0\56\0\2\0\u010d\0\3\0\20\0\12\0\2\0\24\0"+
    "\57\0\1\0\4\0\12\0\1\0\37\0\2\0\120\0\2\0\45\0"+
    "\11\0\2\0\147\0\2\0\65\0\2\0\11\0\52\0\15\0\1\0"+
    "\3\0\1\0\4\0\1\0\27\0\5\0\4\0\1\0\13\0\1\0"+
    "\7\0\64\0\14\0\2\0\62\0\22\0\12\0\12\0\6\0\22\0"+
    "\6\0\3\0\1\0\1\0\2\0\13\0\34\0\10\0\2\0\27\0"+
    "\15\0\14\0\35\0\3\0\4\0\57\0\16\0\16\0\1\0\12\0"+
    "\6\0\5\0\1\0\12\0\12\0\5\0\1\0\51\0\16\0\11\0"+
    "\3\0\1\0\10\0\2\0\2\0\12\0\6\0\27\0\3\0\1\0"+
    "\3\0\62\0\1\0\1\0\3\0\2\0\2\0\5\0\2\0\1\0"+
    "\1\0\1\0\30\0\3\0\2\0\13\0\5\0\2\0\3\0\2\0"+
    "\12\0\6\0\2\0\6\0\2\0\6\0\11\0\7\0\1\0\7\0"+
    "\1\0\53\0\1\0\16\0\6\0\163\0\10\0\1\0\2\0\2\0"+
    "\12\0\6\0\u2ba4\0\14\0\27\0\4\0\61\0\u2104\0\u016e\0\2\0"+
    "\152\0\46\0\7\0\14\0\5\0\5\0\1\0\1\0\12\0\1\0"+
    "\15\0\1\0\5\0\1\0\1\0\1\0\2\0\1\0\2\0\1\0"+
    "\154\0\41\0\u016b\0\22\0\100\0\2\0\66\0\50\0\15\0\3\0"+
    "\20\0\20\0\20\0\3\0\2\0\30\0\3\0\31\0\1\0\6\0"+
    "\5\0\1\0\207\0\2\0\1\0\4\0\1\0\13\0\12\0\7\0"+
    "\32\0\4\0\1\0\1\0\32\0\13\0\131\0\3\0\6\0\2\0"+
    "\6\0\2\0\6\0\2\0\3\0\3\0\2\0\3\0\2\0\22\0"+
    "\3\0\4\0\14\0\1\0\32\0\1\0\23\0\1\0\2\0\1\0"+
    "\17\0\2\0\16\0\42\0\173\0\105\0\65\0\210\0\1\0\202\0"+
    "\35\0\3\0\61\0\17\0\1\0\37\0\40\0\15\0\36\0\5\0"+
    "\46\0\5\0\5\0\36\0\2\0\44\0\4\0\10\0\1\0\5\0"+
    "\52\0\236\0\2\0\12\0\6\0\44\0\4\0\44\0\4\0\50\0"+
    "\10\0\64\0\234\0\u0137\0\11\0\26\0\12\0\10\0\230\0\6\0"+
    "\2\0\1\0\1\0\54\0\1\0\2\0\3\0\1\0\2\0\27\0"+
    "\12\0\27\0\11\0\37\0\101\0\23\0\1\0\2\0\12\0\26\0"+
    "\12\0\32\0\106\0\70\0\6\0\2\0\100\0\1\0\3\0\1\0"+
    "\2\0\5\0\4\0\4\0\1\0\3\0\1\0\35\0\2\0\3\0"+
    "\4\0\1\0\40\0\35\0\3\0\35\0\43\0\10\0\1\0\34\0"+
    "\2\0\31\0\66\0\12\0\26\0\12\0\23\0\15\0\22\0\156\0"+
    "\111\0\67\0\63\0\15\0\63\0\15\0\44\0\4\0\10\0\12\0"+
    "\u0146\0\52\0\1\0\2\0\3\0\2\0\116\0\35\0\12\0\1\0"+
    "\10\0\26\0\13\0\137\0\25\0\33\0\27\0\11\0\3\0\65\0"+
    "\17\0\37\0\12\0\17\0\4\0\55\0\13\0\2\0\1\0\17\0"+
    "\1\0\2\0\31\0\7\0\12\0\6\0\3\0\44\0\16\0\1\0"+
    "\12\0\4\0\1\0\2\0\1\0\10\0\43\0\1\0\2\0\1\0"+
    "\11\0\3\0\60\0\16\0\4\0\4\0\4\0\1\0\14\0\1\0"+
    "\1\0\1\0\43\0\22\0\1\0\31\0\14\0\6\0\1\0\101\0"+
    "\7\0\1\0\1\0\1\0\4\0\1\0\17\0\1\0\12\0\7\0"+
    "\57\0\14\0\5\0\12\0\6\0\4\0\1\0\10\0\2\0\2\0"+
    "\2\0\26\0\1\0\7\0\1\0\2\0\1\0\5\0\1\0\2\0"+
    "\1\0\7\0\2\0\2\0\2\0\3\0\2\0\1\0\6\0\1\0"+
    "\5\0\5\0\2\0\2\0\7\0\3\0\5\0\213\0\65\0\22\0"+
    "\4\0\5\0\12\0\4\0\1\0\3\0\36\0\60\0\24\0\2\0"+
    "\1\0\1\0\10\0\12\0\246\0\57\0\7\0\2\0\11\0\27\0"+
    "\4\0\2\0\42\0\60\0\21\0\3\0\1\0\13\0\12\0\46\0"+
    "\53\0\15\0\1\0\7\0\12\0\66\0\33\0\2\0\17\0\4\0"+
    "\12\0\306\0\54\0\17\0\145\0\100\0\12\0\25\0\10\0\2\0"+
    "\1\0\2\0\10\0\1\0\2\0\1\0\30\0\6\0\1\0\2\0"+
    "\2\0\4\0\1\0\1\0\1\0\2\0\14\0\12\0\106\0\10\0"+
    "\2\0\47\0\7\0\2\0\7\0\1\0\1\0\1\0\1\0\33\0"+
    "\1\0\12\0\50\0\7\0\1\0\4\0\10\0\1\0\10\0\1\0"+
    "\13\0\56\0\20\0\3\0\1\0\42\0\71\0\u0107\0\11\0\1\0"+
    "\45\0\10\0\1\0\10\0\1\0\17\0\12\0\30\0\36\0\2\0"+
    "\26\0\1\0\16\0\111\0\7\0\1\0\2\0\1\0\46\0\6\0"+
    "\3\0\1\0\1\0\2\0\1\0\7\0\1\0\1\0\10\0\12\0"+
    "\6\0\6\0\1\0\2\0\1\0\40\0\5\0\1\0\2\0\1\0"+
    "\5\0\1\0\7\0\12\0\u0136\0\23\0\4\0\271\0\1\0\54\0"+
    "\4\0\37\0\u039a\0\146\0\157\0\21\0\304\0\u0abc\0\u042f\0\1\0"+
    "\11\0\u0fc7\0\u0247\0\u21b9\0\u0239\0\7\0\37\0\1\0\12\0\146\0"+
    "\36\0\2\0\5\0\13\0\60\0\7\0\11\0\4\0\14\0\12\0"+
    "\11\0\25\0\5\0\23\0\u02b0\0\100\0\200\0\113\0\4\0\1\0"+
    "\1\0\67\0\7\0\4\0\15\0\100\0\2\0\1\0\1\0\1\0"+
    "\13\0\2\0\16\0\u17f8\0\10\0\u04d6\0\52\0\11\0\u22f7\0\u011f\0"+
    "\61\0\3\0\21\0\4\0\10\0\u018c\0\u0904\0\153\0\5\0\15\0"+
    "\3\0\11\0\7\0\12\0\3\0\2\0\1\0\4\0\u14c1\0\5\0"+
    "\3\0\26\0\2\0\7\0\36\0\4\0\224\0\3\0\u01bb\0\125\0"+
    "\1\0\107\0\1\0\2\0\2\0\1\0\2\0\2\0\2\0\4\0"+
    "\1\0\14\0\1\0\1\0\1\0\7\0\1\0\101\0\1\0\4\0"+
    "\2\0\10\0\1\0\7\0\1\0\34\0\1\0\4\0\1\0\5\0"+
    "\1\0\1\0\3\0\7\0\1\0\u0154\0\2\0\31\0\1\0\31\0"+
    "\1\0\37\0\1\0\31\0\1\0\37\0\1\0\31\0\1\0\37\0"+
    "\1\0\31\0\1\0\37\0\1\0\31\0\1\0\10\0\2\0\62\0"+
    "\u0200\0\67\0\4\0\62\0\10\0\1\0\16\0\1\0\26\0\5\0"+
    "\1\0\17\0\u0550\0\7\0\1\0\21\0\2\0\7\0\1\0\2\0"+
    "\1\0\5\0\325\0\55\0\3\0\7\0\7\0\2\0\12\0\4\0"+
    "\1\0\u0171\0\54\0\16\0\5\0\1\0\u0500\0\305\0\13\0\7\0"+
    "\51\0\104\0\7\0\1\0\4\0\12\0\u0356\0\1\0\u014f\0\4\0"+
    "\1\0\33\0\1\0\2\0\1\0\1\0\2\0\1\0\1\0\12\0"+
    "\1\0\4\0\1\0\1\0\1\0\1\0\6\0\1\0\4\0\1\0"+
    "\1\0\1\0\1\0\1\0\1\0\3\0\1\0\2\0\1\0\1\0"+
    "\2\0\1\0\1\0\1\0\1\0\1\0\1\0\1\0\1\0\1\0"+
    "\1\0\2\0\1\0\1\0\2\0\4\0\1\0\7\0\1\0\4\0"+
    "\1\0\4\0\1\0\1\0\1\0\12\0\1\0\21\0\5\0\3\0"+
    "\1\0\5\0\1\0\21\0\u0d34\0\12\0\u0406\0\ua6de\0\42\0\u1035\0"+
    "\13\0\336\0\2\0\u1682\0\16\0\u1d31\0\u0c1f\0\u021e\0\u05e2\0\u134b\0"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uecc0\0"+
    "\1\0\36\0\140\0\200\0\360\0\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\1\2\2\1\3\2\4\2\1\1\5\1\1\1\3"+
    "\1\6\4\1\1\2\1\1\1\4\1\1\1\4\1\0"+
    "\1\7\4\1\2\4\1\0\1\1\1\7\1\0\3\1"+
    "\2\4\1\0\1\1\1\10\1\1\1\4\1\11\1\12"+
    "\5\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\36\0\74\0\132\0\36\0\170\0\226\0\264"+
    "\0\322\0\360\0\360\0\360\0\360\0\u010e\0\u012c\0\u014a"+
    "\0\u0168\0\u0186\0\u01a4\0\u01c2\0\u01e0\0\u01fe\0\u021c\0\36"+
    "\0\u023a\0\u0258\0\u0276\0\u0294\0\u01a4\0\u02b2\0\u02d0\0\u01fe"+
    "\0\360\0\u02ee\0\u030c\0\u032a\0\u0348\0\u0366\0\u0384\0\u0384"+
    "\0\u03a2\0\36\0\u03c0\0\u03de\0\36\0\36\0\u03fc\0\u041a"+
    "\0\u0438\0\u0456\0\36";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\2"+
    "\1\11\2\2\1\12\1\13\1\14\1\15\1\16\1\2"+
    "\1\17\4\2\1\20\2\2\1\21\5\2\1\0\6\2"+
    "\1\0\2\2\4\0\20\2\1\4\1\22\5\2\1\0"+
    "\2\2\2\0\1\4\1\0\16\2\3\0\1\4\12\0"+
    "\1\4\17\0\2\2\1\0\1\2\2\7\1\2\1\23"+
    "\1\2\1\24\1\25\1\2\4\0\2\2\1\25\15\2"+
    "\1\0\1\2\2\7\3\2\1\24\1\25\1\2\4\0"+
    "\2\2\1\25\15\2\1\0\2\2\1\26\3\2\1\0"+
    "\2\2\4\0\16\2\4\0\2\24\66\0\2\16\1\27"+
    "\6\16\1\27\2\16\4\27\1\30\1\31\14\16\2\2"+
    "\1\0\6\2\1\0\2\2\4\0\3\2\1\32\14\2"+
    "\1\0\6\2\1\0\2\2\4\0\10\2\1\33\7\2"+
    "\1\0\6\2\1\0\2\2\4\0\13\2\1\34\4\2"+
    "\1\0\1\22\5\2\1\0\2\2\2\0\1\4\1\0"+
    "\20\2\1\0\1\2\1\35\1\36\2\2\1\36\1\0"+
    "\1\36\1\2\4\0\2\2\1\36\7\2\2\36\2\2"+
    "\4\0\2\24\4\0\1\37\7\0\1\37\13\0\2\2"+
    "\1\0\1\2\2\26\1\40\2\2\1\0\1\2\1\40"+
    "\4\0\20\2\1\0\1\2\2\26\3\2\1\0\2\2"+
    "\4\0\16\2\20\27\1\41\1\42\14\27\2\16\1\27"+
    "\6\16\1\27\2\16\4\27\16\16\2\2\1\0\6\2"+
    "\1\0\2\2\4\0\4\2\1\43\13\2\1\0\6\2"+
    "\1\0\2\2\4\0\11\2\1\44\6\2\1\0\6\2"+
    "\1\0\2\2\4\0\14\2\1\45\3\2\1\0\1\2"+
    "\2\46\2\2\1\46\1\0\1\46\1\2\4\0\2\2"+
    "\1\46\7\2\2\46\2\2\4\0\2\47\1\50\4\0"+
    "\1\50\22\0\36\27\2\2\1\0\6\2\1\0\2\2"+
    "\4\0\5\2\1\51\12\2\1\0\6\2\1\0\1\52"+
    "\1\2\4\0\20\2\1\0\6\2\1\0\2\2\4\0"+
    "\15\2\1\53\2\2\1\0\1\2\2\54\2\2\1\54"+
    "\1\0\1\54\1\2\4\0\2\2\1\54\7\2\2\54"+
    "\2\2\4\0\2\47\30\0\2\2\1\0\6\2\1\0"+
    "\2\2\4\0\6\2\1\55\11\2\1\0\6\2\1\0"+
    "\1\56\1\2\4\0\20\2\1\0\1\2\2\57\2\2"+
    "\1\57\1\0\1\57\1\2\4\0\2\2\1\57\7\2"+
    "\2\57\4\2\1\0\1\2\2\60\2\2\1\60\1\0"+
    "\1\60\1\2\4\0\2\2\1\60\7\2\2\60\4\2"+
    "\1\0\1\2\2\61\2\2\1\61\1\0\1\61\1\2"+
    "\4\0\2\2\1\61\7\2\2\61\4\2\1\0\1\2"+
    "\2\62\2\2\1\62\1\0\1\62\1\2\4\0\2\2"+
    "\1\62\7\2\2\62\4\2\1\0\1\2\2\63\2\2"+
    "\1\63\1\0\1\63\1\2\4\0\2\2\1\63\7\2"+
    "\2\63\2\2";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1140];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\11\1\4\11\11\1\1\0\7\1\1\0\1\1\1\11"+
    "\1\0\5\1\1\0\13\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    public class Tuple {
        public final int line;
        public final int col;
        public final String token;
        public final String type;

        public Tuple(int line, int col, String token, String type) {
            this.line = line;
            this.col = col;
            this.token = token;
            this.type = type;
        }
    }

    Queue<Symbol> symbolPipe = new ConcurrentLinkedQueue<Symbol>();

    int openParenthesis = 0;
    boolean foundString = false;
    int prevLineTabCount = 0;
    StringBuilder string = new StringBuilder();

    public Symbol exportToken(int symNum, Object value, int line, int column) {

        if (value.equals("(")) {
            openParenthesis++;
        }
        else if (value.equals(")")) {
            openParenthesis--;
        }

        if (symNum == sym.TAB) {
            symbolPipe.add(new TabSymbol(symNum, line + 1, column + 1, value));
        }
        else
            symbolPipe.add(new Symbol(symNum, line + 1, column + 1, value));

        if (!symbolPipe.isEmpty()) {
            return symbolPipe.poll();
        } else {
            return new Symbol(sym.EOF);
        }
    }

    public Symbol exportToken(int[] symNums, Object[] values) {

        for (int counter = 0; counter < symNums.length; counter++) {
            if (values[counter].equals("(")) {
                openParenthesis++;
            }
            else if (values[counter].equals(")")) {
                openParenthesis--;
            }

            if (symNums[counter] == sym.TAB) {
                    symbolPipe.add(new TabSymbol(symNums[counter], values[counter]));
            } else {
                symbolPipe.add(new Symbol(symNums[counter], values[counter]));
            }
        }

        if (!symbolPipe.isEmpty()) {
            return symbolPipe.poll();
        } else {
            return new Symbol(sym.EOF);
        }
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ElpisLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 3678) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case YYINITIAL: {
              if (!symbolPipe.isEmpty()) {
        return symbolPipe.poll();
    } else {
        return new Symbol(sym.EOF);
    }
            }  // fall though
            case 52: break;
            default:
          { return new java_cup.runtime.Symbol(sym.EOF); }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { if (!foundString) return exportToken(sym.WORD, yytext(), yyline, yycolumn); else string.append(yytext());
            } 
            // fall through
          case 11: break;
          case 2: 
            { String text = yytext();

    if (text.contains(" ")) {
        if (text.length() > prevLineTabCount) {
            if (openParenthesis == 0)
            if ((text.length() - prevLineTabCount) / 2 == 1) {
                prevLineTabCount = text.length();
                return exportToken(sym.START, yytext(), yyline, yycolumn);
            } else {
                int[] syms = new int[(prevLineTabCount - text.length()) / 2];
                for (int counter = 0; counter < (prevLineTabCount - text.length()) / 2; counter++) {
                    syms[counter] = sym.START;
                }
                Object[] values = new Object[(prevLineTabCount - text.length()) / 2];
                for (int counter = 0; counter < values.length; counter++)
                    values[counter] = new Object();
                prevLineTabCount = text.length();
                return exportToken(syms, values);
            }
        } else if (text.length() < prevLineTabCount) {
            if (openParenthesis == 0)
            if ((prevLineTabCount - text.length()) / 2 == 1) {
                prevLineTabCount = text.length();
                return exportToken(sym.END, yytext(), yyline, yycolumn);
            } else {
                int[] syms = new int[(prevLineTabCount - text.length()) / 2];
                for (int counter = 0; counter < (prevLineTabCount - text.length()) / 2; counter++) {
                    syms[counter] = sym.END;
                }
                Object[] values = new Object[(prevLineTabCount - text.length()) / 2];
                for (int counter = 0; counter < values.length; counter++)
                    values[counter] = new Object();
                prevLineTabCount = text.length();
                return exportToken(syms, values);
            }
        }
    }
    else {
        if (text.length() < prevLineTabCount) {
            if ((prevLineTabCount - text.length()) / 2 == 1) {
                prevLineTabCount = text.length();
                return exportToken(sym.END, yytext(), yyline, yycolumn);
            } else {
                int[] syms = new int[(prevLineTabCount - text.length()) / 2];
                for (int counter = 0; counter < (prevLineTabCount - text.length()) / 2; counter++) {
                    syms[counter] = sym.END;
                }
                Object[] values = new Object[(prevLineTabCount - text.length()) / 2];

                for (int counter = 0; counter < values.length; counter++)
                    values[counter] = new Object();
                prevLineTabCount = text.length();
                return exportToken(syms, values);
            }
        }
    }
            } 
            // fall through
          case 12: break;
          case 3: 
            { if (foundString) string.append(yytext());
            } 
            // fall through
          case 13: break;
          case 4: 
            { System.out.println("hello keyhan");
    if (!foundString) {
        try {
            return exportToken(sym.NUMBER, Short.parseShort(yytext()), yyline, yycolumn);
        } catch(Exception ex1) {
            try {
                return exportToken(sym.NUMBER, Integer.parseInt(yytext()), yyline, yycolumn);
            } catch(Exception ex2) {
                try {
                    return exportToken(sym.NUMBER, Long.parseLong(yytext()), yyline, yycolumn);
                } catch(Exception ex3) {
                    try {
                        return exportToken(sym.NUMBER, Float.parseFloat(yytext()), yyline, yycolumn);
                    } catch(Exception ex4) {
                        try {
                            return exportToken(sym.NUMBER, Double.parseDouble(yytext()), yyline, yycolumn);
                        } catch(Exception ex5) {
                            return exportToken(sym.NUMBER, Boolean.parseBoolean(yytext()), yyline, yycolumn);
                        }
                    }
                }
            }
        }
    }
    else string.append(yytext());
            } 
            // fall through
          case 14: break;
          case 5: 
            { return exportToken(sym.WORD, yytext(), yyline, yycolumn);
            } 
            // fall through
          case 15: break;
          case 6: 
            { return exportToken(sym.ANNOT, yytext(), yyline, yycolumn);
            } 
            // fall through
          case 16: break;
          case 7: 
            { String text = yytext(); text = text.replace("\\\"", "\""); return exportToken(sym.STRING, text.substring(1, text.length() - 1), yyline, yycolumn);
            } 
            // fall through
          case 17: break;
          case 8: 
            { if (!foundString) return exportToken(sym.TRUE, yytext(), yyline, yycolumn); else string.append(yytext());
            } 
            // fall through
          case 18: break;
          case 9: 
            { if (!foundString) return exportToken(sym.EMPTY, yytext(), yyline, yycolumn); else string.append(yytext());
            } 
            // fall through
          case 19: break;
          case 10: 
            { if (!foundString) return exportToken(sym.FALSE, yytext(), yyline, yycolumn); else string.append(yytext());
            } 
            // fall through
          case 20: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java ElpisLexer [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        ElpisLexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new ElpisLexer(reader);
          while ( !scanner.zzAtEOF ) scanner.next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
