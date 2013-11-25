#!/bin/bash
echo "Adicionando TODAS as mudanças"
git add .
git add -u .

echo "Mensagem do commit (1 para pular)"
read _commit

echo "Informe a branch (1 para atual): "
read _branch

if [ "$_commit" != "1" ] 
then
	echo "Comitando"
	git commit -m "$_commit"
fi	

if [ "$_branch" != "1" ] 
then
	echo "Push: origin > $_branch" 
	git push origin $_branch
else
	_branch=$(git branch | sed -n '/\* /s///p')
	echo "Push: origin > $_branch" 
	git push origin $_branch
fi	