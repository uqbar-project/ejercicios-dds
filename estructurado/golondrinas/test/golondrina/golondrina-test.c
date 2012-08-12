#include <stdio.h>
#include <assert.h>

#ifdef AVANZADO
  #include  "../../src/golondrina-avanzada/golondrina.h"
  #define MODO "avanzado"
#else
  #include "../../src/golondrina-basica/golondrina.h"
  #define MODO "basico"
#endif

void pepita_gana_energia_cuando_come() {
  Golondrina * pepita = golondrina_new_con_energia(2);
  golondrina_comer(pepita, 4);
  assert(golondrina_energia(pepita) == 10);
  golondrina_delete(&pepita);
}

void pepita_pierde_energia_cuando_vuela() {
  Golondrina * pepita = golondrina_new_con_energia(8);
  golondrina_volar(pepita, 2);
  assert(golondrina_energia(pepita) == 4);
  golondrina_delete(&pepita);
}

void pepita_esta_cansada_si_tiene_poca_energia() {
  Golondrina * pepita = golondrina_new_con_energia(1);
  assert(golondrina_esta_cansada(pepita));
  golondrina_delete(&pepita);
}

void pepita_no_esta_cansada_si_tiene_mucha_energia() {
  Golondrina * pepita = golondrina_new_con_energia(10);
  assert(!golondrina_esta_cansada(pepita));
  golondrina_delete(&pepita);
}

int main() {
  pepita_gana_energia_cuando_come();
  pepita_pierde_energia_cuando_vuela();
  pepita_esta_cansada_si_tiene_poca_energia();
  pepita_no_esta_cansada_si_tiene_mucha_energia();
  puts("Pasó Test " MODO " de Golondrina" );
  return 0;
}

