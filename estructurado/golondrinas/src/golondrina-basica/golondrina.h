#ifndef GOLONDRINA_H_
#define GOLONDRINA_H_

#include "../minilib/types.h"

typedef struct {
  int energia;
} Golondrina;

Golondrina * golondrina_new_con_energia(int self);
void golondrina_delete(Golondrina ** self);

boolean golondrina_esta_cansada(Golondrina * self);
int golondrina_energia(Golondrina * self);
void golondrina_comer(Golondrina * self, int gramos_de_alpiste);
void golondrina_volar(Golondrina * self, int kilometros);


#endif
