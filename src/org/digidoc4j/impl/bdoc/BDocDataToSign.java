/* DigiDoc4J library
*
* This software is released under either the GNU Library General Public
* License (see LICENSE.LGPL).
*
* Note that the only valid version of the LGPL license as far as this
* project is concerned is the original GNU Library General Public License
* Version 2.1, February 1999
*/

package org.digidoc4j.impl.bdoc;

import org.digidoc4j.DataToSign;
import org.digidoc4j.Signature;
import org.digidoc4j.SignatureParameters;

public class BDocDataToSign extends DataToSign {

  private AsicFacade asicFacade;

  public BDocDataToSign(byte[] digestToSign, SignatureParameters signatureParameters, AsicFacade asicFacade) {
    super(digestToSign, signatureParameters);
    this.asicFacade = asicFacade;
  }

  @Override
  public Signature finalize(byte[] signatureValue) {
    return asicFacade.signRaw(signatureValue);
  }
}