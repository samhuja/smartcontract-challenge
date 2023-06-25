// Solidity program to implement
// global variables
pragma solidity ^0.8.0;

contract GlobalVariablesExample {
	
address public owner;
constructor()
{
	// set the contract owner to the address
	// that deployed the contract
	owner = msg.sender;
}
	
function getOwner() public view returns (address)
{
	// return the contract owner address
	return owner;
}
	
function isOwner(address _address) public view returns (bool)
{
	// check if the provided address matches
	// the contract owner
	return _address == owner;
}
	
function sendEther(address payable _recipient) public payable
{
	// send ether to the specified recipient
	require(msg.sender == owner,
			"Only the contract owner can send ether.");
	_recipient.transfer(msg.value);
}
	
function getCurrentBlock() public view returns (uint,
												uint, address)
{
	// return the current block number, timestamp,
	// and coinbase address
	return (block.number, block.timestamp, block.coinbase);
}
}
