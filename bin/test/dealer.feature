#language: ru

Функциональность: Дилер берёт карты себе

  Структура сценария: пока у не не будет 17 или больше
    Допустим у дилера на руках "<есть карты>"
    Когда он "<берет карту>" из колоды
    Тогда "<в результате>"

    Примеры:
      | есть карты | берет карту | в результате   |
      | Q          | 6           | может взять    |
      | Q          | 7           | не может взять |
      | A          | Q           | не может взять |

