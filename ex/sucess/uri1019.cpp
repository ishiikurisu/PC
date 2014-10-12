#include <iostream>

main()
{
	int dt, h, m, s;
	std::cin >> dt;
	s = dt;
	m = s / 60;
	s = s % 60;
	h = m / 60;
	m = m % 60;
	std::cout << h << ':' << m << ':' << s << '\n';
}
