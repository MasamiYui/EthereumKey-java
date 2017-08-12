package org.baoshichain.cryto;

import javax.xml.bind.DatatypeConverter;

import org.ethereum.geth.Account;
import org.ethereum.geth.Geth;
import org.ethereum.geth.KeyStore;

import java.io.IOException;
import java.security.*;

/**
 * Created by nik on 21/07/17.
 */

public class main {
	public static void main(String[] args) throws NoSuchAlgorithmException,
			NoSuchProviderException, InvalidAlgorithmParameterException,
			IOException {

		// Get secp256k1 pair - which we can use for both addresses
		ECKeyPair keyPair = ECKeyPair.createECKeyPair();
		System.out.println("Private key: " + keyPair.getPrivateKey() + " - "
				+ keyPair.getPrivateKey().length());
		System.out.println("Public key: " + keyPair.getPublicKey() + " - "
				+ keyPair.getPublicKey().length());
 
		// Calculate Bitcoin Address
		// BtcAddressGen.genBitcoinAddress(keyPair.getPublicKey());

		// Calculate Ethereum Address
		EthAddressGen.genEthereumAddress(keyPair.getPublicKey());
		
		KeyStore ks = new KeyStore("/keystore", Geth.LightScryptN, Geth.LightScryptP);
		Account newAcc;
		try {
			newAcc = ks.newAccount("123");
			byte[] jsonAcc = ks.exportKey(newAcc, "123", "123");
			System.out.println(jsonAcc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
