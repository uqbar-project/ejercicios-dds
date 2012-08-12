#include "golondrina.h"
#include "../minilib/instance.h"

adt_define(Golondrina, {
   int energia;
});

Golondrina * golondrina_new_con_energia(int energia) {
  Golondrina * self = new();
  self()->energia = energia;
  return self;
}

void golondrina_delete(Golondrina ** self) {
  self_delete();
}

int golondrina_energia(Golondrina * self) {
  return self()->energia;
}

boolean golondrina_esta_cansada(Golondrina * self) {
  return self()->energia < 2;
}

void golondrina_comer(Golondrina * self, int gramos_de_alpiste) {
  self()->energia += gramos_de_alpiste * 2;
}
void golondrina_volar(Golondrina * self, int kilometros) {
  self()->energia -= kilometros * 2;
}

