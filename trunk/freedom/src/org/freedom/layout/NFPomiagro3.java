/**
 * @version 14/07/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Robson Sanchez <BR>
 *
 * Projeto: Freedom <BR>
 * Pacote: layout <BR>
 * Classe: @(#)NFPomiagro2.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Layout da nota fiscal para a empresa Pomiagro Ltda.
 */

package org.freedom.layout;
import java.math.BigDecimal;
import java.util.Vector;

import org.freedom.componentes.ImprimeOS;
import org.freedom.componentes.NF;
import org.freedom.funcoes.Funcoes;

public class NFPomiagro3 extends Layout {
	
	public boolean imprimir(NF nf,ImprimeOS imp) {
	
		boolean retorno = super.imprimir(nf, imp);
		boolean bFat = true;
		final int MAXLINE = 26;
		int iNumNota = 0;
		int iItImp = 0;
		int iContaAst = 1;
		int iMesImp = 0;
		int iObsImp = 0;
		int iContaFrete = 0;
		int iLinPag = imp.verifLinPag("NF");
		String sTipoTran = null ;
		String sObs = null;
		String sTmp = null;
		String sDescAdic = null;
		String sImpDtSaidaNat = null;
		String sIncra = null ;
		String sClasFisc = null;
		String[] sValsCli = new String[4];
		String[] sNat = new String[2];
		String[] sDuplics = new String[6];
		String[] sVencs = new String[6];
		String[] sVals = new String[6];
		String[] sMatObs = new String[5]; 
		Vector vObs = new Vector();
		Vector vMens = new Vector();
		Vector vMensT1 = new Vector();
		Vector vMensT2 = new Vector();
		
		try{
			
			if (cab.next())
				iNumNota = cab.getInt(NF.C_DOC);
			
			for (int i=0; i<6; i++) {
				if (bFat) {
					if (parc.next()) {
						sDuplics[i] = iNumNota + " / " + parc.getInt(NF.C_NPARCITREC);
						sVencs[i] = (parc.getDate(NF.C_DTVENCTO)!=null ? Funcoes.dateToStrDate(parc.getDate(NF.C_DTVENCTO)) : "");
						sVals[i] = Funcoes.strDecimalToStrCurrency(12,2,""+parc.getFloat(NF.C_VLRPARC));
					} else {
						bFat = false;
						sDuplics[i] = "";
						sVencs[i] = "";
						sVals[i] = "";
					}
				} else {
					bFat = false;
					sVencs[i] = "";
					sVals[i] = "";
				}
			}
			
			imp.limpaPags();
			boolean bNat = true;
			while (itens.next()) {
				if (bNat) {
					sNat[0] = itens.getString(NF.C_DESCNAT);
					sNat[1] = Funcoes.setMascara(itens.getString(NF.C_CODNAT),"#.###");
					bNat = false;				     
				}
				if (adic.next()) {
					sValsCli[0] = !adic.getString(NF.C_CPFEMITAUX).equals("") ? adic.getString(NF.C_CPFEMITAUX) : cab.getString(NF.C_CPFEMIT);
					sValsCli[1] = !adic.getString(NF.C_NOMEEMITAUX).equals("") ? adic.getString(NF.C_NOMEEMITAUX) : cab.getString(NF.C_RAZEMIT);
					sValsCli[2] = !adic.getString(NF.C_CIDEMITAUX).equals("") ? adic.getString(NF.C_CIDEMITAUX) : cab.getString(NF.C_CIDEMIT);
					sValsCli[3] = !adic.getString(NF.C_UFEMITAUX).equals("") ? adic.getString(NF.C_UFEMITAUX) : cab.getString(NF.C_UFEMIT);
				} else {
					sValsCli[0] = cab.getString(NF.C_CPFEMIT);
					sValsCli[1] = cab.getString(NF.C_RAZEMIT);
					sValsCli[2] = cab.getString(NF.C_CIDEMIT);
					sValsCli[3] = cab.getString(NF.C_UFEMIT); 
				}
				if (imp.pRow()==0) {					

					sIncra = cab.getString(NF.C_INCRAEMIT);
					sImpDtSaidaNat = itens.getString(NF.C_IMPDTSAIDA);
					
					imp.say(imp.pRow()+1,0, imp.comprimido());
					
					if (nf.getTipoNF()==NF.TPNF_ENTRADA)
						imp.say(imp.pRow()+0,108,"X");
					else
						imp.say(imp.pRow()+0,94,"X");
					
					imp.say(imp.pRow(),128, Funcoes.strZero(""+iNumNota,6));
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, sNat[0]);
					imp.say(imp.pRow(), 51, sNat[1]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());           
					   
					if (!sIncra.equals("")){
						imp.say(imp.pRow(),  6, cab.getInt(NF.C_CODEMIT)+" - "+sValsCli[1]+"Incra:");
						imp.say(imp.pRow(), 73, cab.getString(NF.C_INCRAEMIT));
					} else
						imp.say(imp.pRow(),  6, cab.getInt(NF.C_CODEMIT)+" - "+sValsCli[1]);
					    
					imp.say(imp.pRow(), 96, !sValsCli[0].equals("") ? Funcoes.setMascara(sValsCli[0],"###.###.###-##") : Funcoes.setMascara(cab.getString(NF.C_CNPJEMIT),"##.###.###/####-##")) ;
					imp.say(imp.pRow(),126, (cab.getDate(NF.C_DTEMITPED)!=null ? Funcoes.dateToStrDate(cab.getDate(NF.C_DTEMITPED)) : ""));
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, Funcoes.copy(cab.getString(NF.C_ENDEMIT),0,50).trim()+", "+(!cab.getString(NF.C_NUMEMIT).equals("") ? Funcoes.copy(cab.getString(NF.C_NUMEMIT),0,6).trim() : "").trim()+" - "+(cab.getString(NF.C_COMPLEMIT) != null ? Funcoes.copy(cab.getString(NF.C_COMPLEMIT),0,9).trim() : "").trim());
					imp.say(imp.pRow(), 86, cab.getString(NF.C_BAIREMIT));
					imp.say(imp.pRow(),110, Funcoes.setMascara(cab.getString(NF.C_CEPEMIT),"#####-###"));
					
					if (!sImpDtSaidaNat.equals("N"))
						imp.say(imp.pRow(),126, (cab.getDate(NF.C_DTSAIDA)!=null ? Funcoes.dateToStrDate(cab.getDate(NF.C_DTSAIDA)) : ""));
					
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, sValsCli[2]);
					imp.say(imp.pRow(), 65, (!cab.getString(NF.C_DDDEMIT).equals("") ? "("+cab.getString(NF.C_DDDEMIT)+")" : "")+
											(!cab.getString(NF.C_FONEEMIT).equals("") ? Funcoes.setMascara(cab.getString(NF.C_FONEEMIT).trim(),"####-####") : "").trim());
					imp.say(imp.pRow(), 89, sValsCli[3]);
					imp.say(imp.pRow(), 98, !cab.getString(NF.C_RGEMIT).equals("") ? cab.getString(NF.C_RGEMIT) : cab.getString(NF.C_INSCEMIT));
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, sDuplics[0]);
					imp.say(imp.pRow(), 30, sVencs[0]);
					imp.say(imp.pRow(), 55, sVals[0]);
					imp.say(imp.pRow(), 80, sDuplics[1]);
					imp.say(imp.pRow(),105, sVencs[1]);
					imp.say(imp.pRow(),125, sVals[1]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, sDuplics[2]);
					imp.say(imp.pRow(), 30, sVencs[2]);
					imp.say(imp.pRow(), 55, sVals[2]);
					imp.say(imp.pRow(), 80, sDuplics[3]);
					imp.say(imp.pRow(),105, sVencs[3]);
					imp.say(imp.pRow(),125, sVals[3]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, sDuplics[4]);
					imp.say(imp.pRow(), 30, sVencs[4]);
					imp.say(imp.pRow(), 55, sVals[4]);
					imp.say(imp.pRow(), 80, sDuplics[5]);
					imp.say(imp.pRow(),105, sVencs[5]);
					imp.say(imp.pRow(),125, sVals[5]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
				}
				
				 //Descri��es adicionais colocadas junto a decri��o do produto.
				 
				sDescAdic = ""; 
				 //Gambs para colocar o lote:
				if ((itens.getDate(NF.C_VENCLOTE) != null) && (!itens.getString(NF.C_CODLOTE).equals("")))
					sDescAdic = "  - L.:"+itens.getString(NF.C_CODLOTE).trim()+", VC.:"+Funcoes.dateToStrDate(itens.getDate(NF.C_VENCLOTE)).substring(3);
				
				sTmp = !itens.getString(NF.C_DESCFISC).equals("") ? itens.getString(NF.C_DESCFISC).trim() : ""; 
				 //Gambs para colocar arteriscos:
				if (sTmp.length() > 0) {					
					int i = 0;
					for(;i<vMensT1.size();i++) {						
						if (((String[])vMensT1.elementAt(i))[1].equals(sTmp) &&
							((String[])vMensT1.elementAt(i))[0].indexOf("*") == 0) {
							sDescAdic += " "+((String[])vMensT1.elementAt(i))[0];
							break;
						}
					}				
					if (i == vMensT1.size()) {
						vMensT1.add(new String[] {Funcoes.replicate("*",iContaAst++),sTmp});
						sDescAdic += " "+((String[])vMensT1.elementAt(i))[0];
						vMens.add(((String[])vMensT1.elementAt(i))[0] + " - " +((String[])vMensT1.elementAt(i))[1]);
					}
				}
				
				sTmp = !itens.getString(NF.C_DESCFISC2).equals("") ? itens.getString(NF.C_DESCFISC2).trim() : "";
				sClasFisc = Funcoes.copy(itens.getString(NF.C_ORIGFISC),0,1)+Funcoes.copy(itens.getString(NF.C_CODTRATTRIB),0,2);
				if (sTmp.length() > 0) {
					int i = 0;
					for(;i<vMensT2.size();i++) {						
						if (((String[])vMensT2.elementAt(i))[0].equals(sClasFisc)) {
							break;
						}
					}				
					if (i == vMensT2.size()) {
						vMensT2.add(new String[] {sClasFisc,sTmp});
						vMens.add(((String[])vMensT2.elementAt(i))[0] + " - " +((String[])vMensT2.elementAt(i))[1]);
					}
											
				}		 

				imp.say(imp.pRow()+1,0, imp.comprimido());
				imp.say(imp.pRow(),  2, Funcoes.alinhaDir(itens.getInt(NF.C_CODPROD),8));
				imp.say(imp.pRow(), 15, Funcoes.copy(itens.getString(NF.C_DESCPROD).trim(),0,66-sDescAdic.length()) + sDescAdic);
				imp.say(imp.pRow(), 87, sClasFisc);
				imp.say(imp.pRow(), 93, itens.getString(NF.C_CODUNID).substring(0,4));
				imp.say(imp.pRow(),100, String.valueOf(itens.getFloat(NF.C_QTDITPED)));          
				imp.say(imp.pRow(),104, Funcoes.strDecimalToStrCurrency(13,2,String.valueOf((new BigDecimal(itens.getFloat(NF.C_VLRLIQITPED))).divide(new BigDecimal(itens.getFloat(NF.C_QTDITPED)),2,BigDecimal.ROUND_HALF_UP))));
				imp.say(imp.pRow(),121, Funcoes.strDecimalToStrCurrency(13,2,String.valueOf(itens.getFloat(NF.C_VLRLIQITPED))));
				imp.say(imp.pRow(),136, ((int)itens.getFloat(NF.C_PERCICMSITPED))+"%");
				
				iItImp++;
				System.out.println(imp.pRow()+" = iItImp : "+iItImp);
				if ((iItImp == itens.getInt(NF.C_CONTAITENS)) || (imp.pRow() == MAXLINE - 1)) {
					if (iContaFrete == 0){
						frete.next();
						iContaFrete++;
					}
					//Ganbs para n�o repetir menssagem.
					if(sObs == null) {
						sObs = cab.getString(NF.C_OBSPED).trim();
						vObs = Funcoes.strToVectorSilabas(sObs,75);
					}
					sMatObs = new String[]{"","","","",""};
					for(int i=0; i<5; i++) {
						if(iMesImp<vMens.size())
							sMatObs[i] = (String)vMens.elementAt(iMesImp++);
						else if(iObsImp<vObs.size())
							sMatObs[i] = (String)vObs.elementAt(iObsImp++);
					}
										
					int iRow = imp.pRow();
					for (int i=0; i<(MAXLINE-iRow);i++)
						imp.say(imp.pRow()+1,0, imp.comprimido());
					
					if (iItImp == itens.getInt(NF.C_CONTAITENS)) {             
						imp.say(imp.pRow()+1,0, imp.comprimido());         
						imp.say(imp.pRow(),  4, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRBASEICMSPED))));
						imp.say(imp.pRow(), 32, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRICMSPED))));
						imp.say(imp.pRow(),114, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRPRODPED))));
						imp.say(imp.pRow()+1,0, imp.comprimido());
						imp.say(imp.pRow()+1,0, imp.comprimido());
						imp.say(imp.pRow(),  4, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(frete.getFloat(NF.C_VLRFRETEPED))));
						imp.say(imp.pRow(), 58, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRADICPED))));
						imp.say(imp.pRow(), 87, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRIPIPED))));
						imp.say(imp.pRow(),114, Funcoes.strDecimalToStrCurrency(20,2,String.valueOf(itens.getFloat(NF.C_VLRLIQPED))));
						iItImp = 0;						
					} else if (imp.pRow() == MAXLINE) {
						imp.say(imp.pRow()+1,0, imp.comprimido());
						imp.say(imp.pRow(),  4, "***************");
						imp.say(imp.pRow(), 32, "***************");
						imp.say(imp.pRow(),114, "***************");
						imp.say(imp.pRow()+1,0, imp.comprimido());
						imp.say(imp.pRow()+1,0, imp.comprimido());
						imp.say(imp.pRow(),  4, "***************");
						imp.say(imp.pRow(), 58, "***************");
						imp.say(imp.pRow(), 87, "***************");
						imp.say(imp.pRow(),114, "***************");
					}
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, frete.getString(NF.C_RAZTRANSP));
					imp.say(imp.pRow(), 85, frete.getString(NF.C_TIPOFRETE).equals("C") ? "1" : "2");
					imp.say(imp.pRow(), 95, frete.getString(NF.C_PLACAFRETE));
					imp.say(imp.pRow(),111, frete.getString(NF.C_UFFRETE));
					   
					sTipoTran = frete.getString(NF.C_TIPOTRANSP);
						
					if ( sTipoTran.equals("C") )
						imp.say(imp.pRow(),116, Funcoes.setMascara(cab.getString(NF.C_CNPJEMIT) ,"##.###.###/####-##"));
					else 
						imp.say(imp.pRow(),116, Funcoes.setMascara(frete.getString(NF.C_CNPJTRANSP) ,"##.###.###/####-##"));
					
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, Funcoes.copy(frete.getString(NF.C_ENDTRANSP),0,42)+", "+Funcoes.copy(frete.getString(NF.C_NUMTRANSP),0,6));
					imp.say(imp.pRow(), 70, frete.getString(NF.C_CIDTRANSP));
					imp.say(imp.pRow(),111, frete.getString(NF.C_UFTRANSP));
					
					
					if (frete.getString(NF.C_TIPOTRANSP).equals("C"))
						imp.say(imp.pRow(),116, cab.getString(NF.C_INSCEMIT));
					else 
						imp.say(imp.pRow(),116, frete.getString(NF.C_INSCTRANSP));
					   
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  6, Funcoes.strDecimalToStrCurrency(5,casasDec,String.valueOf(frete.getString(NF.C_QTDFRETE))));
					imp.say(imp.pRow(), 26, frete.getString(NF.C_ESPFRETE));
					imp.say(imp.pRow(), 47, frete.getString(NF.C_MARCAFRETE));
					imp.say(imp.pRow(), 93, Funcoes.strDecimalToStrCurrency(5,casasDec,String.valueOf(frete.getFloat(NF.C_PESOBRUTO))));
					imp.say(imp.pRow(),120, Funcoes.strDecimalToStrCurrency(5,casasDec,String.valueOf(frete.getString(NF.C_PESOLIQ))));
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(), 12, cab.getString(NF.C_CODVEND));
					imp.say(imp.pRow(), 21, cab.getString(NF.C_CODCLCOMIS));
					imp.say(imp.pRow(), 30, Funcoes.strDecimalToStrCurrency(5,2,String.valueOf(Funcoes.arredFloat(cab.getFloat(NF.C_PERCMCOMISPED),2))).toString());
					imp.say(imp.pRow(), 48, String.valueOf(cab.getInt(NF.C_CODPED)));
					imp.say(imp.pRow(), 66, String.valueOf(iNumNota));
					imp.say(imp.pRow()+1,0, imp.comprimido());
					   
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  4, sMatObs[0]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  4, sMatObs[1]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  4, sMatObs[2]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  4, sMatObs[3]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(),  4, sMatObs[4]);
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow()+1,0, imp.comprimido());
					imp.say(imp.pRow(), 10, String.valueOf(iNumNota));
					   
					System.out.println(imp.pRow()+" =T Lins: "+iLinPag);
					for (int i=imp.pRow(); i<=iLinPag; i++) 
						imp.say(imp.pRow()+1,0, imp.comprimido());
					
					imp.setPrc(0,0);
					imp.incPags();
				}
			}
			
			imp.fechaGravacao();
			retorno = true;
			
		} catch ( Exception err ) {
			Funcoes.mensagemErro(null,"Erro ao montar nota \n" + err.getMessage()); 
			err.printStackTrace();
		} finally {
			sTipoTran = null ;
			sObs = null;
			sTmp = null;
			sDescAdic = null;
			sImpDtSaidaNat = null;
			sIncra = null ;
			sClasFisc = null;
			sValsCli = null;
			sNat = null;
			sDuplics = null;
			sVencs = null;
			sVals = null;
			sMatObs = null; 
			vObs = null;
			vMens = null;
			vMensT1 = null;
			vMensT2 = null;
			System.gc();
		}
		
		return retorno;
		
	}
	
}
