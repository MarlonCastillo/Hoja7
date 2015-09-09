/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja7;


public class Association <K, V>{
	protected K Key;
	protected V Value;

	public Association(K key, V value){
		Key = key;
		Value = value;
	}
	public V getValue(){
		return Value;
	}
	public K getKey(){
		return Key;
	}
	public V setValue(V value){
		V oldValue = Value;
		Value = value;
		return oldValue;
	}
}
