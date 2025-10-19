#include <iostream>
#include "pga3d/pga3d.h"

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
int main() {
    // TIP Press <shortcut actionId="RenameElement"/> when your caret is at the <b>lang</b> variable name to see how CLion can help you rename it.
    constexpr auto point = pga3d::Point(1, 2, 3);
    constexpr auto projectivePoint = pga3d::ProjectivePoint(3, 4, 5, 6);

    pga3d::Point p{.z = 2};
    std::cout << p << std::endl;
    std::cout << projectivePoint << std::endl;
    auto p3 = pga3d::ProjectivePoint{.x = 3, .y = 4, .z = 5, .w = 6};
    std::cout << p3.reverse() << std::endl;
    std::cout << p3.antiReverse() << std::endl;
    std::cout << p3.normalizedByWeight() << std::endl;

    return 0;
    // TIP See CLion help at <a href="https://www.jetbrains.com/help/clion/">jetbrains.com/help/clion/</a>. Also, you can try interactive lessons for CLion by selecting 'Help | Learn IDE Features' from the main menu.
}